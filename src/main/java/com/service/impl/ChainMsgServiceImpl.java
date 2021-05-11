package com.service.impl;

import com.dataobject.ChainDO;
import com.response.CommonReturnType;
import com.response.RPCReturnType;
import com.service.ChainMsgService;

import java.util.List;

public class ChainMsgServiceImpl implements ChainMsgService {

    @Override
    public List<String> getAllChainMsgByUserId(String userId) {
        return null;
    }

    @Override
    public RPCReturnType getUserChainMsgPRCWay(String chainId) {
        return null;
    }

    @Override
    public CommonReturnType getUserChainMsgLocally(String chainId) {
        return null;
    }

    @Override
    public RPCReturnType addNewChainMsgPRCWay(ChainDO chainDO) {
        return null;
    }

    @Override
    public RPCReturnType removeChainMsgPRCWay(String chainId) {
        return null;
    }
}
