package com.service;

import com.response.CommonReturnType;

import java.util.HashMap;

public interface MigrationService {

    //主动迁移，用户上传迁移
    CommonReturnType userMigrate(String userId, String taskId, String hostName, String desAddr);

    //被动迁移，由主节点的远程RPC拉起进行迁移及其校验即可
    CommonReturnType scheduledMigrate(String taskId, HashMap<String, String> migrationMap,
                                      String presentNodeId, String nextNodeId);
}
