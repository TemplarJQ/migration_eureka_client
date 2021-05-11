package com.response;

public class RPCReturnType {

    //处理结果有"success"和"fail"

    //若返回值为success则data内产生前端需要的json数据
    //若返回值为fail，则返回data内通用的错误码格式
    private String status;
    private Object data;

    //默认返回成功
    public static RPCReturnType create(Object object){
        return RPCReturnType.create(object, "success");
    }

    //否则返回失败
    public static RPCReturnType create(Object object, String status){

        RPCReturnType type = new RPCReturnType();
        type.setData(object);
        type.setStatus(status);
        return type;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
