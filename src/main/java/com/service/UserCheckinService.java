package com.service;

import com.dataobject.VisiterDO;
import com.response.CommonReturnType;
import com.response.RPCReturnType;

public interface UserCheckinService {

    CommonReturnType userRegister(VisiterDO visiterDO);

    CommonReturnType userCheckinLocally(String userId, String password);

    CommonReturnType userCheckinRPCWay(String userId, String password);

    RPCReturnType adminRegister(VisiterDO visiterDO);

    RPCReturnType adminCheckinRPCWay(String adminId, String password);
}
