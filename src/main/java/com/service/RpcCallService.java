package com.service;

import com.response.CommonReturnType;

public interface RpcCallService {

    CommonReturnType sendRpcCall(String nodeName, String apiName);

    CommonReturnType sendRpc2Server(String apiName);
}
