package com.service.impl;

import com.config.RpcApiConfig;
import com.response.CommonReturnType;
import com.response.RPCReturnType;
import com.service.RpcCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RpcCallServiceImpl implements RpcCallService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public CommonReturnType sendRpcCall(String nodeName, String apiName) {
        RPCReturnType result = restTemplate.getForEntity(RpcApiConfig.getRpcUrlService(nodeName, apiName), RPCReturnType.class).getBody();
        return CommonReturnType.create(result.getData());
    }

    @Override
    public CommonReturnType sendRpc2Server(String apiName) {
        RPCReturnType result = restTemplate.getForEntity(RpcApiConfig.rpcUrl2Server(apiName), RPCReturnType.class).getBody();
        return CommonReturnType.create(result.getData());
    }
}
