package com.dataobject;

public class TaskDO {

    private String taskId;

    private String ownerId;

    private String chainId;

    private Integer taskType;

    private String resultAddr;

    private String otherMsg;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getResultAddr() {
        return resultAddr;
    }

    public void setResultAddr(String resultAddr) {
        this.resultAddr = resultAddr;
    }

    public String getOtherMsg() {
        return otherMsg;
    }

    public void setOtherMsg(String otherMsg) {
        this.otherMsg = otherMsg;
    }

    public TaskDO(String taskId, String ownerId, String chainId, Integer taskType, String resultAddr, String otherMsg) {
        this.taskId = taskId;
        this.ownerId = ownerId;
        this.chainId = chainId;
        this.taskType = taskType;
        this.resultAddr = resultAddr;
        this.otherMsg = otherMsg;
    }

    public TaskDO() {
    }
}
