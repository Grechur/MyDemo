package com.example.designpattern.factory;

/**
 * Created by Zc on 2018/3/1.
 */

public class PlumJuice extends Drink {
    @Override
    String getInstantPackage() {
        return "速溶酸梅粉";
    }

    @Override
    String getName() {
        return "酸梅";
    }
}
