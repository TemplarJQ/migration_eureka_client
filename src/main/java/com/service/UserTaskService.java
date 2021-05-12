package com.service;

import com.dataobject.TaskDO;
import com.response.CommonReturnType;

public interface UserTaskService {

    CommonReturnType starkUsualTask(TaskDO taskDO);

    CommonReturnType queryUsualTask(String userId, String taskId);

}
