package com.controller;

import com.constants.ChainConstants;
import com.constants.TaskConstants;
import com.constants.UserConstants;
import com.dataobject.*;
import com.error.BusinessException;
import com.error.UserError;
import com.response.CommonReturnType;
import com.response.RPCReturnType;
import com.service.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


@Controller("user")
@RequestMapping("/user")
//对跨域请求参数进行设置保证session中的信息跨域得到读取
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class UserController extends BaseController{

    @Autowired
    private CacheService cacheService;

    @Autowired
    private UserCheckinService userCheckinService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private ChainMsgService chainMsgService;

    @Autowired
    private NodeService nodeService;

    @Autowired
    private UserTaskService userTaskService;

    @Autowired
    private ScheduledTaskService scheduledTaskService;

    //用户注册
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType userRegister(@RequestParam(name = "userName") String userName,
                                         @RequestParam(name = "registerMode") String registerMode,
                                         @RequestParam(name = "encrptPassword") String encrptPassword) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        //入参校验
        if(StringUtils.isEmpty(encrptPassword) || StringUtils.isEmpty(userName) || StringUtils.isEmpty(registerMode)){
            throw new BusinessException(UserError.PARAMETER_VALIDATION_ERROR);
        }

        //密码加密处理
        String password = enCodeByMD5(encrptPassword);

        //构建VisiterDO,登录模式默认为手机接入,用户等级默认为最低
        VisiterDO visiter = new VisiterDO(userName, UserConstants.getRegisterMode(registerMode), UserConstants.ORIGINAL, password);

        //向注册中心发RPC请求注册用户,失败则抛全局异常并注明RPC错误
        RPCReturnType result = userCheckinService.userRegister(visiter);

        if (result.getStatus().equals("success")) return CommonReturnType.create(result.getData());
        else return CommonReturnType.create(result.getData(), "fail");
    }

    //用户接入
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType userLogin(@RequestParam(name = "userId") String userId,
                                      @RequestParam(name = "password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        //入参校验
        if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(password)){
            throw new BusinessException(UserError.PARAMETER_VALIDATION_ERROR);
        }
        //redis黑白名单检测
        //TODO：redis全局黑名单检测

        //远程RPC校验
        RPCReturnType result = userCheckinService.userCheckinRPCWay(userId, this.enCodeByMD5(password));
        //名单校验失败
        if (!"success".equals(result.getStatus())) return CommonReturnType.create(result.getData(), "fail");

        //将登陆凭证加入到用户登陆成功的session中
        this.httpServletRequest.getSession().setAttribute("IS_LOGIN",true);
        this.httpServletRequest.getSession().setAttribute("LOGIN_USER",result.getData());

        //生成登录凭证,UUID
        String uuidToken = UUID.randomUUID().toString();
        uuidToken = uuidToken.replace("-", "");

        //输出到控制台
        System.out.println(this.httpServletRequest.getSession().getAttribute("IS_LOGIN"));

        //下发token
        return CommonReturnType.create(uuidToken);
    }

    public String enCodeByMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        Base64.Encoder encoder = Base64.getEncoder();
        String newStr = encoder.encodeToString(md5.digest(str.getBytes("utf-8")));
        //        BASE64Encoder base64Encoder = new BASE64Encoder();
        // 加密字符串
        //        String newStr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        return newStr;
    }

    //获取所有链ID
    @RequestMapping(value = "/getAllChainById", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType getAllChainMsgByUserId(@RequestParam(name = "userId") String userId) throws BusinessException {

        //入参校验
        if(StringUtils.isEmpty(userId)){
            throw new BusinessException(UserError.PARAMETER_VALIDATION_ERROR);
        }

        //远程查询用户所有链id
        List<String> chainIdList = chainMsgService.getAllChainMsgByUserId(userId);

        return CommonReturnType.create(chainIdList);
    }

    //获取链信息
    @RequestMapping(value = "/getChainMsg", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType getChainMsgById(@RequestParam(name = "chainId") String chainId,
                                            @RequestParam(name = "callMode") String callMode) throws BusinessException{

        //入参校验
        if(StringUtils.isEmpty(chainId) || StringUtils.isEmpty(callMode)){
            throw new BusinessException(UserError.PARAMETER_VALIDATION_ERROR);
        }

        CommonReturnType result = null;
        if (callMode.equals(ChainConstants.CHAIN_CALL_BY_RPC)) {
            result = chainMsgService.getUserChainMsgPRCWay(chainId);
        } else if (callMode.equals(ChainConstants.CHAIN_CALL_BY_LOCAL)) {
            result = chainMsgService.getUserChainMsgLocally(chainId);
        } else {
            return CommonReturnType.create("链信息查询方式参数上传错误");
        }

        return CommonReturnType.create(result.getData());
    }

    //添加链信息
    @RequestMapping(value = "/addChain", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType addChain(@RequestParam(name = "chainId") String chainId,
                                     @RequestParam(name = "serviceNum") int serviceNum,
                                     @RequestParam(name = "updateUserId") String updateUserId,
                                     @RequestParam(name = "addrMap") HashMap<Integer, String> addrMap) throws BusinessException {

        //入参校验
        if (StringUtils.isEmpty(chainId) || StringUtils.isEmpty(updateUserId)
                || null == addrMap || serviceNum != addrMap.size()
                || serviceNum > ChainConstants.CHAIN_SERVICE_NUM_LIMIT) {
            throw new BusinessException(UserError.PARAMETER_VALIDATION_ERROR);
        }

        ChainDO chain = new ChainDO(chainId, serviceNum, updateUserId, addrMap);

        RPCReturnType result = chainMsgService.addNewChainMsgPRCWay(chain);

        //日志探针
        if ("success".equals(result.getStatus())) {
            return CommonReturnType.create(result.getData());
        } else {
            return CommonReturnType.create(result.getData(), "远程调用RPC添加链信息失败");
        }

    }

    //删除链信息
    @RequestMapping(value = "/deleteChain", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType deleteChain(@RequestParam(name = "chainId") String chainId) throws BusinessException {

        //入参校验
        if (StringUtils.isEmpty(chainId)) {
            throw new BusinessException(UserError.PARAMETER_VALIDATION_ERROR);
        }

        RPCReturnType result = chainMsgService.removeChainMsgPRCWay(chainId);

        //日志探针
        if ("success".equals(result.getStatus())) {
            return CommonReturnType.create(result.getData());
        } else {
            return CommonReturnType.create(result.getData(), "远程调用RPC删除链信息失败");
        }

    }

    //获取节点信息
    @RequestMapping(value = "/getNodeMsg", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType getNodeMsg(@RequestParam(name = "userId") String userId) throws BusinessException {

        //入参校验
        if(StringUtils.isEmpty(userId)){
            throw new BusinessException(UserError.PARAMETER_VALIDATION_ERROR);
        }

        NodeMsgDO result = nodeService.getNodeMsgByUserId(userId);

        if (null != result) {
            return CommonReturnType.create(result);
        } else {
            return CommonReturnType.create(null, "查询本地节点返回值为空");
        }

    }

    //提交、运行链任务
    @RequestMapping(value = "/startUsualTask", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType startUsualTask(@RequestParam(name = "userId") String userId,
                                           @RequestParam(name = "chainId") String chainId,
                                           @RequestParam(name = "resultAddr") String resultAddr,
                                           @RequestParam(name = "otherMsg") String otherMsg) throws BusinessException {

        //入参校验
        if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(chainId)
                || StringUtils.isEmpty(resultAddr) || StringUtils.isEmpty(otherMsg)){
            throw new BusinessException(UserError.PARAMETER_VALIDATION_ERROR);
        }

        TaskDO taskDO = new TaskDO(getUUID(), userId, chainId, TaskConstants.USUAL_TASK, resultAddr, otherMsg);

        CommonReturnType result = userTaskService.starkUsualTask(taskDO);

        //日志探针
        if ("success".equals(result.getStatus())) {
            return CommonReturnType.create(result.getData());
        } else {
            return CommonReturnType.create(result.getData(), "开启普通链式任务失败");
        }
    }

    //获取任务执行信息
    @RequestMapping(value = "/queryUsualTask", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType queryUsualTask(@RequestParam(name = "userId") String userId,
                                           @RequestParam(name = "taskId") String taskId) throws BusinessException {
        //入参校验
        if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(taskId)){
            throw new BusinessException(UserError.PARAMETER_VALIDATION_ERROR);
        }

        CommonReturnType result = userTaskService.queryUsualTask(userId, taskId);

        //日志探针
        if ("success".equals(result.getStatus())) {
            return CommonReturnType.create(result.getData());
        } else {
            return CommonReturnType.create(result.getData(), "查询已开启的链式任务失败");
        }
    }

    public String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.replace("-", "");
    }


    //提交计划任务表
    @RequestMapping(value = "/uploadScheduledTask", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType uploadScheduledTask(@RequestParam(name = "userId") String userId,
                                                @RequestParam(name = "chainId") String chainId,
                                                @RequestParam(name = "resultAddr") String resultAddr,
                                                @RequestParam(name = "otherMsg") String otherMsg,
                                                @RequestParam(name = "scheduledMap") HashMap<String, String> scheduledMap) throws BusinessException {

        //入参校验
        if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(chainId)
                || StringUtils.isEmpty(resultAddr) || StringUtils.isEmpty(otherMsg) || null == scheduledMap){
            throw new BusinessException(UserError.PARAMETER_VALIDATION_ERROR);
        }

        ScheduledTaskDO staskDO = new ScheduledTaskDO(getUUID(), userId, chainId, TaskConstants.USUAL_TASK, resultAddr, otherMsg, scheduledMap);

        CommonReturnType result = scheduledTaskService.uploadScheduledTask(staskDO);

        //日志探针
        if ("success".equals(result.getStatus())) {
            return CommonReturnType.create(result.getData());
        } else {
            return CommonReturnType.create(result.getData(), "上传计划任务到中心节点");
        }
    }
}
