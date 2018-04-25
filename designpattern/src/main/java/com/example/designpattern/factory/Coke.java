package com.example.designpattern.factory;

/**
 * Created by Zc on 2018/3/1.
 */

public class Coke extends Drink {
    @Override
    String getInstantPackage() {
        return "速溶可乐粉";
    }

    @Override
    String getName() {
        return "可乐";
    }
}
