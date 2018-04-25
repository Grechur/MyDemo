package com.example.designpattern.abstrafactory;

/**
 * Created by Zc on 2018/3/1.
 */

public class SbiStore implements Store {
    @Override
    public String getAddress() {
        return "关山创业街";
    }

    @Override
    public String getName() {
        return "SBI店";
    }
}
