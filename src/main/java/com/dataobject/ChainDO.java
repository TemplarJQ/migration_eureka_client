package com.dataobject;

import java.util.HashMap;

public class ChainDO {

    private String chainId;

    private int serviceNum;

    private String updateUserId;

    private HashMap<Integer, String> addrMap;

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public int getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(int serviceNum) {
        this.serviceNum = serviceNum;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public HashMap<Integer, String> getAddrMap() {
        return addrMap;
    }

    public void setAddrMap(HashMap<Integer, String> addrMap) {
        this.addrMap = addrMap;
    }

    public ChainDO(String chainId, int serviceNum, String updateUserId, HashMap<Integer, String> addrMap) {
        this.chainId = chainId;
        this.serviceNum = serviceNum;
        this.updateUserId = updateUserId;
        this.addrMap = addrMap;
    }

    public ChainDO() {
    }
}
