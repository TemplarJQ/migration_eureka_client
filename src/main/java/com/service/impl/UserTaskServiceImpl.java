package com.service.impl;

import com.dataobject.TaskDO;
import com.response.CommonReturnType;
import com.service.UserTaskService;
import org.springframework.stereotype.Service;

@Service
public class UserTaskServiceImpl implements UserTaskService {

    @Override
    public CommonReturnType starkUsualTask(TaskDO taskDO) {
        return null;
    }

    @Override
    public CommonReturnType queryUsualTask(String userId, String taskId) {
        return null;
    }
}
