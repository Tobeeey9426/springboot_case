package com.atguigu.springboot.utils;

import java.io.Serializable;

public class Result implements Serializable {

    private boolean status ; //响应状态  true  false
    private String msg ;  // 响应信息
    private Object data ;  //处理成功的响应数据

    public  static Result ok(boolean status,String msg,Object data){
        Result result = new Result();

        result.setStatus(status);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public  static Result error(boolean status,String msg){
        Result result = new Result();

        result.setStatus(status);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
