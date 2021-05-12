package com.service.impl;

import com.response.CommonReturnType;
import com.service.MigrationService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MigrationServiceImpl implements MigrationService{
    @Override
    public CommonReturnType userMigrate(String userId, String taskId, String hostName, String desAddr) {
        return null;
    }

    @Override
    public CommonReturnType scheduledMigrate(String taskId, HashMap<String, String> migrationMap, String presentNodeId, String nextNodeId) {
        return null;
    }
}
