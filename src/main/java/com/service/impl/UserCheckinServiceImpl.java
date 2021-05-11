package com.service.impl;

import com.dataobject.VisiterDO;
import com.response.CommonReturnType;
import com.service.UserCheckinService;
import org.springframework.stereotype.Service;

@Service
public class UserCheckinServiceImpl implements UserCheckinService {

    @Override
    public CommonReturnType userRegister(VisiterDO visiterDO) {
        //调用RPC注册
        return null;
    }

    @Override
    public CommonReturnType userCheckinLocally(Integer userId) {
        return null;
    }

    @Override
    public CommonReturnType userCheckinRPCWay(Integer userId) {
        return null;
    }
}
