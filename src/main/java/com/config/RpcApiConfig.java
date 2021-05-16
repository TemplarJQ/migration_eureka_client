package com.config;

/**
 @author ljq，注：客户端服务端的调用接口常量（即手动配置中心，可以替换为Apollo或Spring Clouds原生组件）
 */
public class RpcApiConfig {

    //节点前缀
    private static final String PREFIX = "http://";

    //服务端相关端口:

    //服务端用户注册API
    public static final String SERVER_USER_REGISTER_API = "/user/register";


    public static String getRpcUrlService(String nodeName, String service) {
        return PREFIX + nodeName + service;
    }

    public static String rpcUrl2Server(String service) {
        return getRpcUrlService("EDGE_SERVER", service);
    }
}
