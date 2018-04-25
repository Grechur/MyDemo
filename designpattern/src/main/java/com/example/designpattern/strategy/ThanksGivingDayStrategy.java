package com.example.designpattern.strategy;

/**
 * Created by Zc on 2018/3/1.
 */

public class ThanksGivingDayStrategy implements ActivityStrategy{
    @Override
    public String getActivityPrice() {
        return "(感恩节)所有饮品一律5折";
    }
}
