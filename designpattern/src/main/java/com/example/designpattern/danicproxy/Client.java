package com.example.designpattern.danicproxy;

import java.lang.reflect.Proxy;

/**
 * Created by zz on 2018/5/11.
 */

public class Client {
    public static void main(String[] args) {
        Man man = new Man("Grechur");

        IBank bank = (IBank) Proxy.newProxyInstance(IBank.class.getClassLoader(),
                new Class<?>[] {IBank.class},
                new BankInvocationHandler(man));
        bank.applyCard();
        bank.lostCard();
        bank.extraCard();
    }
}
