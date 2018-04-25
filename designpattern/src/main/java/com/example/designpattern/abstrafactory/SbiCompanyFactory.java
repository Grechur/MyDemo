package com.example.designpattern.abstrafactory;

/**
 * Created by Zc on 2018/3/1.
 */

public class SbiCompanyFactory implements CompanyFactory {
    @Override
    public Store createStore() {
        return new SbiStore();
    }

    @Override
    public Checkstand createCheckstand() {
        return new SbiCheckStand();
    }

    @Override
    public Tableware createTableware() {
        return new SbiTableware();
    }
}
