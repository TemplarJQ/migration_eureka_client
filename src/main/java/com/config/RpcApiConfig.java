package com.config;

import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

/**
 @author ljq，注：客户端服务端的调用接口常量（即手动配置中心，可以替换为Apollo或Spring Clouds原生组件）
 */
public class RpcApiConfig {

    //节点前缀
    private static final String PREFIX = "http://";

    //服务端相关端口:

    //服务端用户注册API
    public static final String SERVER_USER_REGISTER_API = "/user/register";
    public static final String SERVER_USER_LOGIN_API = "/user/login";


    public static String getRpcUrlService(String nodeName, String service) {
        return PREFIX + nodeName + service;
    }

    public static String getRpcUrlService(String nameName, String service, Map<String, String> map) {
        return addParam2Url(getRpcAddress(nameName, service), map);
    }

    public static String rpcUrl2Server(String service) {
        return getRpcUrlService("EDGE-SERVER", service);
    }

    public static String rpcUrl2Server(String service, Map<String, String> map) {
        return getRpcUrlService("EDGE-SERVER", service, map);
    }

    private static String getRpcAddress(String nodeName, String service) {
        return PREFIX + nodeName + service;
    }

    private static String addParam2Url(String url, Map<String, String> map) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        map.entrySet().stream().forEach(o -> builder.queryParam(o.getKey(),o.getValue()));
        return builder.build().encode().toString();
    }
}
