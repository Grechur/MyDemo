package com.example.designpattern.strategy;

/**
 * Created by Zc on 2018/3/1.
 */

public class ChristmasStrategy implements ActivityStrategy{
    @Override
    public String getActivityPrice() {
        return "(圣诞节)买热干面+饮品套餐, 送大苹果一个";
    }
}
