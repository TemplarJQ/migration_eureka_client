package com.dataobject;

import java.io.Serializable;
import java.util.HashMap;

public class ChainDO implements Serializable{

    private static final long serialVersionUID = 2724888087391664167L;

    private String chainId;

    private Integer serviceNum;

    private Integer updateUserId;

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

    public void setServiceNum(Integer serviceNum) {
        this.serviceNum = serviceNum;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public HashMap<Integer, String> getAddrMap() {
        return addrMap;
    }

    public void setAddrMap(HashMap<Integer, String> addrMap) {
        this.addrMap = addrMap;
    }

    public ChainDO(String chainId, Integer serviceNum, Integer updateUserId, HashMap<Integer, String> addrMap) {
        this.chainId = chainId;
        this.serviceNum = serviceNum;
        this.updateUserId = updateUserId;
        this.addrMap = addrMap;
    }

    public ChainDO() {
    }
}
