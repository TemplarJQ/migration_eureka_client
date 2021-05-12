package com.service;

import com.dataobject.NodeMsgDO;

public interface NodeService {

    NodeMsgDO getNodeMsgByUserId(String userId);

    NodeMsgDO getNodeMsg4Admin(String adminId);
}
