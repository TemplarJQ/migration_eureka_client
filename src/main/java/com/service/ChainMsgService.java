package com.service;

import com.dataobject.ChainDO;
import com.response.CommonReturnType;
import com.response.RPCReturnType;

import java.util.List;

public interface ChainMsgService {

    //获取所有链ID
    List<String> getAllChainMsgByUserId(String userId);

    //获取链信息操作
    RPCReturnType getUserChainMsgPRCWay(String chainNum);

    CommonReturnType getUserChainMsgLocally(String chainNum);

    //增加链信息
    RPCReturnType addNewChainMsgPRCWay(ChainDO chainDO);
    //去除链信息
    RPCReturnType removeChainMsgPRCWay(String chainNum);

}
