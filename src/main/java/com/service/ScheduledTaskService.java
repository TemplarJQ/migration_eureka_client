package com.service;

import com.dataobject.ScheduledTaskDO;
import com.response.CommonReturnType;

public interface ScheduledTaskService {

    //计划下发模块，目前需要和服务端联调书写
    CommonReturnType uploadScheduledTask(ScheduledTaskDO scheduledTaskDO);
}
