package com.service;

import com.dataobject.ChainDO;
import com.response.CommonReturnType;
import com.response.RPCReturnType;

public interface ChainMsgService {

    //链信息操作
    RPCReturnType getUserChainMsgPRCWay(String chainNum);

    CommonReturnType getUserChainMsgLocally(String chainNum);

    //增加链信息
    RPCReturnType addNewChainMsgPRCWay(ChainDO chainDO);
    //去除链信息
    RPCReturnType removeChainMsgPRCWay(String chainNum);
}
