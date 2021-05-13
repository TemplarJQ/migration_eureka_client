package com.controller;


import com.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping(value = "/discoveryClient", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public CommonReturnType discoveryClientTest() {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        return CommonReturnType.create("hello,client: " + instance.getHost() + ", serviceID: " + instance.getServiceId());
    }
}
