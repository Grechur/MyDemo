package com.example.designpattern.single;

/**
 * Created by Zc on 2018/3/1.
 * 单例模式
 保证一个类(HungryForm)仅有一个实例(sInstance), 并提供一个访问该实例的全局访问点(getInstance).
 这就意味着单例通常有如下两个特点:
 构造函数是私有的(避免别的地方创建它)
 有一个static的方法来对外提供一个该单例的实例.
 */

public class HungryForm extends Form{
    // 提前创建好
    private static HungryForm sInstance = new HungryForm();
    // 私有化的构造, 避免别人直接创建表格
    private HungryForm() {}
    // 店长们通过这个接口来取表格
    public static HungryForm getInstance() {
        return sInstance;
    }
}
