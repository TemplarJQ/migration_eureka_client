package com.service.impl;

import com.dataobject.NodeMsgDO;
import com.service.NodeService;
import org.springframework.stereotype.Service;

@Service
public class NodeServiceImpl implements NodeService {

    @Override
    public NodeMsgDO getNodeMsgByUserId(String userId) {
        return null;
    }

    @Override
    public NodeMsgDO getNodeMsg4Admin(String adminId) {
        return null;
    }
}
