package com.lanlinker.cloud.entity;

/**
 * 统一返回结果处理
 * Created by MetalSteel on 2017/8/30.
 */
public class ResultBean<T> {
    // 结果状态码
    private Integer code;
    // 提示信息
    private String msg;
    // 返回数据
    private T data;

    public ResultBean() {
    }

    public ResultBean(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
