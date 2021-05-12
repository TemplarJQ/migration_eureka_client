package com.controller;

import com.error.BusinessException;
import com.error.UserError;
import com.response.CommonReturnType;
import com.service.MigrationService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller("migrate")
@RequestMapping("/migrate")
//对跨域请求参数进行设置保证session中的信息跨域得到读取
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class MigrationController extends BaseController {

    @Autowired
    private MigrationService migrationService;

    //提交主动迁移任务
    @RequestMapping(value = "/startMigrate", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType startUsualTask(@RequestParam(name = "userId") String userId,
                                           @RequestParam(name = "taskId") String taskId,
                                           @RequestParam(name = "hostName") String hostName,
                                           @RequestParam(name = "desAddr") String desAddr) throws BusinessException {

        //入参校验
        if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(taskId)
                || StringUtils.isEmpty(hostName) || StringUtils.isEmpty(desAddr)){
            throw new BusinessException(UserError.PARAMETER_VALIDATION_ERROR);
        }

        CommonReturnType result = migrationService.userMigrate(userId, taskId, hostName, desAddr);

        //日志探针
        if ("success".equals(result.getStatus())) {
            return CommonReturnType.create(result.getData());
        } else {
            return CommonReturnType.create(result.getData(), "用户主动迁移任务启动失败");
        }
    }
}
