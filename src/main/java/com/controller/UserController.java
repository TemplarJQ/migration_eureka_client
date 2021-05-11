package com.controller;

import com.constants.UserConstants;
import com.dataobject.VisiterDO;
import com.error.BusinessException;
import com.error.UserError;
import com.response.CommonReturnType;
import com.service.CacheService;
import com.service.UserCheckinService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller("user")
@RequestMapping("/user")
//对跨域请求参数进行设置保证session中的信息跨域得到读取
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class UserController extends BaseController{

    @Autowired
    private CacheService cacheService;

    @Autowired
    private UserCheckinService userCheckinService;

    //用户注册
    @RequestMapping(value = "/register", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType userRegister(@RequestParam(name = "userName") String userName,
                                         @RequestParam(name = "registerMode") String registerMode,
                                         @RequestParam(name = "encrptPassword") String encrptPassword) throws BusinessException {
        //入参校验
        if(StringUtils.isEmpty(encrptPassword) || StringUtils.isEmpty(userName) || StringUtils.isEmpty(registerMode)){
            throw new BusinessException(UserError.PARAMETER_VALIDATION_ERROR);
        }

        //登录

        //构建VisiterDO,登录模式默认为手机接入,用户等级默认为最低
        VisiterDO visiter = new VisiterDO(userName, UserConstants.getRegisterMode(registerMode), UserConstants.ORIGINAL, encrptPassword);

        //向注册中心发RPC请求注册用户,失败则抛全局异常并注明RPC错误
        userCheckinService.userRegister(visiter);

        return CommonReturnType.create("注册成功");
    }

    //用户接入
    @RequestMapping(value = "/login", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType userLogin(@RequestParam(name = "userId") Integer userId,
                                      @RequestParam(name = "encrptPassword") String encrptPassword) throws BusinessException {


        return CommonReturnType.create(null);
    }



}
