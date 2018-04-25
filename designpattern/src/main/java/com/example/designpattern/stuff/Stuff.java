package com.example.designpattern.stuff;


/**
 * Created by Zc on 2018/3/1.
 * 装饰者模式就是用来动态的给对象加上额外的职责.
 Drink是被装饰的对象, Stuff作为装饰类, 可以动态地给被装饰对象添加特征, 职责.
 Builder模式是一种创建型的设计模式. 旨在解决对象的差异化构建的问题.
 装饰者模式是一种结构型的设计模式. 旨在处理对象和类的组合关系.
 */

public abstract class Stuff implements Drink{
    private Drink joinDrink;
    public Stuff(Drink joinDrink){
        this.joinDrink = joinDrink;
    }

    @Override
    public String make() {
        return joinDrink.make() + ", 加一份" + stuffName();
    }

    abstract String stuffName();
}
