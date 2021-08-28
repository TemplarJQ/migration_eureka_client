package com.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.config.RpcApiConfig;
import com.dataobject.VisiterDO;
import com.response.CommonReturnType;
import com.response.RPCReturnType;
import com.service.RpcCallService;
import com.service.UserCheckinService;
import com.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCheckinServiceImpl implements UserCheckinService {

    @Autowired
    RpcCallService rpcCallService;

    @Override
    public CommonReturnType userRegister(VisiterDO visiterDO) {

        //visitor转userModel
        UserModel userModel = new UserModel();
        userModel.setUserName(visiterDO.getUserName());
        userModel.setEncrptPassword(visiterDO.getEncrptPassword());
        userModel.setRegisterMode(visiterDO.getRegisterMode());
        userModel.setUserLevel(visiterDO.getUser_level());

        //调用远端RPC
        String json = JSONObject.toJSONString(userModel);
        return rpcCallService.sendRpc2Server(RpcApiConfig.SERVER_USER_REGISTER_API, json);
    }

    @Override
    public CommonReturnType userCheckinLocally(String userId, String password) {
        return null;
    }

    @Override
    public CommonReturnType userCheckinRPCWay(String userId, String password) {

        //userModel记录id和密码
        UserModel userModel = new UserModel();
        userModel.setUserId(Integer.parseInt(userId));
        userModel.setEncrptPassword(password);

        //调用远端RPC
        String json = JSONObject.toJSONString(userModel);
        return rpcCallService.sendRpc2Server(RpcApiConfig.SERVER_USER_LOGIN_API, json);
    }

    @Override
    public RPCReturnType adminRegister(VisiterDO visiterDO) {
        return null;
    }

    @Override
    public RPCReturnType adminCheckinRPCWay(String adminId, String password) {
        return null;
    }
}
