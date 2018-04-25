package com.example.designpattern.factory;

/**
 * Created by Zc on 2018/3/1.
 */

public class OrangeJuice extends Drink {
    @Override
    String getInstantPackage() {
        return "速溶橙汁粉";
    }

    @Override
    String getName() {
        return "橙汁";
    }
}
