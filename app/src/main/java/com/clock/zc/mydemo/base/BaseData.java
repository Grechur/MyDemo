package com.clock.zc.mydemo.base;

/**
 * Created by Zc on 2017/12/20.
 */

public class BaseData<T> {
    private String err_msg;
    private int code;
    private T data;

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
