package com.service;

import com.dataobject.VisiterDO;
import com.response.CommonReturnType;

public interface UserCheckinService {

    CommonReturnType userRegister(VisiterDO visiterDO);

    CommonReturnType userCheckinLocally(Integer userId);

    CommonReturnType userCheckinRPCWay(Integer userId);
}
