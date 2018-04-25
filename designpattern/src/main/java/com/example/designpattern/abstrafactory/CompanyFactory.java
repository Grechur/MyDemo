package com.example.designpattern.abstrafactory;

/**
 * Created by Zc on 2018/3/1.
 */

public interface CompanyFactory {
    Store createStore();

    Checkstand createCheckstand();

    Tableware createTableware();
}
