package com.controller;

import com.error.BusinessException;
import com.response.CommonReturnType;
import com.service.CacheService;
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

    //用户接入
    @RequestMapping(value = "/login", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType userLogin(@RequestParam(name = "userId") Integer userId,
                                      @RequestParam(name = "userName") String userName,
                                      @RequestParam(name = "registerMode") String registerMode,
                                      @RequestParam(name = "thirdPartyId") String thirdPartyId) throws BusinessException {


        return CommonReturnType.create(null);
    }


}
