package com.example.designpattern.strategy;

/**
 * Created by Zc on 2018/3/1.
 */

public class DefaultActivityStrategy implements ActivityStrategy{
    @Override
    public String getActivityPrice() {
        return "没有活动";
    }
}
