package com.response;

public class RPCReturnType extends CommonReturnType {

    //异常信息等便于日志调用
    private String msg;

    //默认返回成功
    public static RPCReturnType create(Object object){
        return RPCReturnType.create(object, "success", "rpc call");
    }

    //否则返回失败
    public static RPCReturnType create(Object object, String status, String msg){

        RPCReturnType type = new RPCReturnType();
        type.setData(object);
        type.setStatus(status);
        type.setMsg(msg);
        return type;

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
