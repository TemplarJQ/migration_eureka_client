package com.error;

public enum UserError implements CommonError {

    //通用错误类型10001，解决入参校验
    PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),
    //未知错误
    UNKNOWN_ERROR(10002, "未知错误"),

    //20000开头表示为用户信息相关错误
    USER_LOGIN_FAIL(20001, "用户验证失败"),
    USER_IN_BLACKLIST(20002,"用户黑名单中，请一段时间后再发起任务"),

    //30000开头表示任务相关错误
    TASK_SEND_ERROR(30001, "任务发送失败")
    ;

    UserError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private int errCode;
    private String errMsg;

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
