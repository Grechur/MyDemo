package com.example.designpattern.danicproxy;

import sun.nio.cs.ext.IBM037;

/**
 * Created by zz on 2018/5/11.
 */

public class Man implements IBank {
    String mName;
    public Man(String name){
        this.mName = name;
    }
    @Override
    public void applyCard() {
        System.out.println(mName+"申请办卡");
    }

    @Override
    public void lostCard() {
        System.out.println(mName+"申请挂失");
    }

    @Override
    public void extraCard() {
        System.out.println(mName+"申请退卡");
    }
}
