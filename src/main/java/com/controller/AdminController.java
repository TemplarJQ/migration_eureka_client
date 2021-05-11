package com.controller;

import com.constants.UserConstants;
import com.dataobject.VisiterDO;
import com.error.BusinessException;
import com.error.UserError;
import com.response.CommonReturnType;
import com.response.RPCReturnType;
import com.service.CacheService;
import com.service.UserCheckinService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

@Controller("admin")
@RequestMapping("/admin")
//对跨域请求参数进行设置保证session中的信息跨域得到读取
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class AdminController extends BaseController{

    @Autowired
    private CacheService cacheService;

    @Autowired
    private UserCheckinService userCheckinService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    //用户注册
    @RequestMapping(value = "/register", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType adminRegister(@RequestParam(name = "adminName") String adminName,
                                         @RequestParam(name = "encrptPassword") String encrptPassword) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        //入参校验
        if(StringUtils.isEmpty(encrptPassword) || StringUtils.isEmpty(adminName)){
            throw new BusinessException(UserError.PARAMETER_VALIDATION_ERROR);
        }

        //密码加密处理
        String password = enCodeByMD5(encrptPassword);

        //构建VisiterDO,登录模式默认为手机接入,用户等级默认为最低
        VisiterDO visiter = new VisiterDO(adminName, null, UserConstants.ADMIN, password);

        //向注册中心发RPC请求注册用户,失败则抛全局异常并注明RPC错误
        RPCReturnType result = userCheckinService.adminRegister(visiter);

        if (result.getStatus().equals("success")) return CommonReturnType.create(result.getData());
        else return CommonReturnType.create(result.getData(), "fail");
    }

    //用户接入
    @RequestMapping(value = "/login", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType userLogin(@RequestParam(name = "adminId") String adminId,
                                      @RequestParam(name = "password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {

        //入参校验
        if(StringUtils.isEmpty(adminId) || StringUtils.isEmpty(password)){
            throw new BusinessException(UserError.PARAMETER_VALIDATION_ERROR);
        }

        //远程RPC校验
        RPCReturnType result = userCheckinService.adminCheckinRPCWay(adminId, this.enCodeByMD5(password));
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
}
