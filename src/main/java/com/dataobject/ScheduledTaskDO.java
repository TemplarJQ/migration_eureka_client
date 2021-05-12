package com.dataobject;

import java.util.HashMap;

public class ScheduledTaskDO extends TaskDO{

    private HashMap<String, String> scheduledMap;

    public ScheduledTaskDO(String taskId, String ownerId, String chainId, Integer taskType,
                           String resultAddr, String otherMsg, HashMap<String, String> scheduledMap) {
        super(taskId, ownerId, chainId, taskType, resultAddr, otherMsg);
        this.scheduledMap = scheduledMap;
    }

    public ScheduledTaskDO(String taskId, String ownerId, String chainId,
                           Integer taskType, String resultAddr, String otherMsg) {
        super(taskId, ownerId, chainId, taskType, resultAddr, otherMsg);
    }

    public ScheduledTaskDO() {
    }
}
