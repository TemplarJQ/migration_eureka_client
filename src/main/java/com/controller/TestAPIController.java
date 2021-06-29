package com.controller;


import com.response.RPCReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller("test")
@RequestMapping("/test")
//对跨域请求参数进行设置保证session中的信息跨域得到读取
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class TestAPIController extends BaseController{

    @Autowired
    private DiscoveryClient discoveryClient;

    //hello
    @RequestMapping(value = "/hello", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String helloTest() {
        return "hello, world!";
    }

    //节点信息
//    @RequestMapping(value = "/discoveryClient", method = {RequestMethod.POST, RequestMethod.GET})
//    @ResponseBody
//    public RPCReturnType discoveryClientTest() {
//        ServiceInstance instance = discoveryClient.
//        return RPCReturnType.create("hello,client: " + instance.getHost() + ", serviceID: " + instance.getServiceId());
//    }

    //测试有参数发送
    @RequestMapping(value = "/paramTest", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public RPCReturnType paramTest(String name) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return RPCReturnType.create("hello: " + request.getRequestURI() + ", name: " + name);
    }

}
