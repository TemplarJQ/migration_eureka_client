package com.service.impl;

import com.dataobject.VisiterDO;
import com.response.CommonReturnType;
import com.response.RPCReturnType;
import com.service.UserCheckinService;
import org.springframework.stereotype.Service;

@Service
public class UserCheckinServiceImpl implements UserCheckinService {

    @Override
    public RPCReturnType userRegister(VisiterDO visiterDO) {
        //调用远端RPC

        return null;
    }

    @Override
    public CommonReturnType userCheckinLocally(String userId, String password) {
        return null;
    }

    @Override
    public RPCReturnType userCheckinRPCWay(String userId, String password) {
        return null;
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
