package com.service;

import com.dataobject.VisiterDO;
import com.response.CommonReturnType;
import com.response.RPCReturnType;

public interface UserCheckinService {

    RPCReturnType userRegister(VisiterDO visiterDO);

    CommonReturnType userCheckinLocally(String userId, String password);

    RPCReturnType userCheckinRPCWay(String userId, String password);

    RPCReturnType adminRegister(VisiterDO visiterDO);

    RPCReturnType adminCheckinRPCWay(String adminId, String password);
}
