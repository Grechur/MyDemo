package com.example.designpattern.abstrafactory;

/**
 * Created by Zc on 2018/3/1.
 * 抽象工厂
 提供一个创建一系列相关或互相依赖的对象的接口, 而无需指定它们的具体实现.
 */

public class Xiaoguan {
    public static void main(String[] args) {
        CompanyFactory factory = new SbiCompanyFactory();
        Company company = new Company(factory.createStore(),factory.createCheckstand(),factory.createTableware());
        System.out.println(company.toString());
    }
}
