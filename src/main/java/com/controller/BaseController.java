package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    public static final String CONTENT_TYPE_FORMED = "application/x-www-form-urlencoded";

    //定义ExceptionHandler解决未被controller层吸收的exception
    //    @ExceptionHandler(Exception.class)
    //    @ResponseStatus(HttpStatus.OK)//屏蔽tomcat自己的处理
    //    @ResponseBody
    //    public Object handlerException(HttpServletRequest request, Exception ex) {
    //        Map<String, Object> responseData = new HashMap<>();
    //        if(ex instanceof BusinessException) {
    //            BusinessException exception = (BusinessException) ex;
    //            responseData.put("errCode", exception.getErrCode());
    //            responseData.put("errMsg", exception.getErrMsg());
    //        }else {
    //            responseData.put("errCode", SystemError.UNKNOWN_ERROR.getErrCode());
    //            responseData.put("errMSg", SystemError.UNKNOWN_ERROR.getErrMsg());
    //
    //        }
    //        return CommonReturnType.create(responseData, "fail");
    //    }
    //解决全局问题


    //为解决全局问题，将该部分内容也加入到了全局异常处理的范畴里
}
