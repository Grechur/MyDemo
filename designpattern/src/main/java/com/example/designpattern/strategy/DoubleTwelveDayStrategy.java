package com.example.designpattern.strategy;

/**
 * Created by Zc on 2018/3/1.
 */

public class DoubleTwelveDayStrategy implements ActivityStrategy{
    @Override
    public String getActivityPrice() {
        return "(双十二)满12立减2元";
    }
}
