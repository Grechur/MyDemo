package com.example.designpattern.strategy;

/**
 * Created by Zc on 2018/3/1.
 * 策略模式(Strategy Pattern):
 定义一组算法, 并将每一个单独算法封装起来, 让它们可以相互替换.
 首先简单工厂和工厂方法是创建型的模式, 而策略模式是行为型的模式.
 所谓创建型就是说用来生产对象的, 注重的生产(new)这个部分, 用创建型的模式来代替直接new一个实例, 更多是想将直接的实例依赖通过不同的方法转化接口依赖.
 所谓行为型模式更多是描述一种行为, A使用B, 怎么使用的这个关系上.
 */

public class Checkstand {
    private ActivityStrategy mActivityStrategy;
    public Checkstand() {
        mActivityStrategy = new DefaultActivityStrategy();
    }
    public Checkstand(ActivityStrategy activityStrategy) {
        this.mActivityStrategy = activityStrategy;
    }
    public void setActivityStrategy(ActivityStrategy activityStrategy) {
        this.mActivityStrategy = activityStrategy;
    }
    public void printBill() {
        System.out.println("本次账单活动:" + mActivityStrategy.getActivityPrice());
    }
}
