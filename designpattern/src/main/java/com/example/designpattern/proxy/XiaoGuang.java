package com.example.designpattern.proxy;

/**
 * Created by Zc on 2018/3/1.
 */

public class XiaoGuang implements Person{
    @Override
    public void signing(int price) {
        System.out.println("小光以" + price + "每箱的价格签单.");
    }
}
