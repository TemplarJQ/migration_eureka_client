package com.dataobject;

public class NodeMsgDO {

    //节点ID
    private String nodeId;
    //节点地址，ip+端口
    private String nodeAddr;
    //实例主机位置
    private String hostName;
    //全局应用名
    private String app;
    //实例状态
    private String status;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeAddr() {
        return nodeAddr;
    }

    public void setNodeAddr(String nodeAddr) {
        this.nodeAddr = nodeAddr;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public NodeMsgDO(String nodeId, String nodeAddr, String hostName, String app, String status) {
        this.nodeId = nodeId;
        this.nodeAddr = nodeAddr;
        this.hostName = hostName;
        this.app = app;
        this.status = status;
    }

    public NodeMsgDO() {
    }
}
