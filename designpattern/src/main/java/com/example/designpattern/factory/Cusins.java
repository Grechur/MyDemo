package com.example.designpattern.factory;

/**
 * Created by Zc on 2018/3/1.
 * 1, 为何叫工厂方法, 是因为每个工厂有一个方法来创建产品.
 2, 每个产品对应一个工厂实例来生产这个产品实例.
 3, 因为产品和其对应的工厂都与其他产品分离, 我们可以很轻易的去增加新的产品和其对应的工厂, 而不改变原来的结构. (开闭原则, 实际上还蕴含了职责单一)
 */

public class Cusins {
    private IBeverageMachine machine;
    public void setBeverageMachine(IBeverageMachine machine) {
        this.machine = machine;
    }
    public Drink takeDrink() {
        if (machine == null) throw new NullPointerException("Should set Beverage Machine firstly.");
        return machine.makeDrink();
    }


    public static void main(String[] args) {

        Cusins cousins = new Cusins();
        // for A
        cousins.setBeverageMachine(new OrangeJuiceMachine());
        Drink drink = cousins.takeDrink();
        System.out.println(drink);
        // for B
        cousins.setBeverageMachine(new CokeMachine());
        System.out.println(cousins.takeDrink());
    }
}
