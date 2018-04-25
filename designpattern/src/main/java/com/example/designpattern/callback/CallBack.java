package com.example.designpattern.callback;

/**
 * Created by Zc on 2018/3/12.
 */

public interface CallBack {
    /**
     * 这个是小李知道答案时要调用的函数告诉小王，也就是回调函数
     * @param result 是答案
     */
    public void solve(String result);
}
