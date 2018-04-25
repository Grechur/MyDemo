package com.example.designpattern.factory;

/**
 * Created by Zc on 2018/3/1.
 */

public abstract class Drink {
    private String name;
    private String instantPackage;
    public Drink make() {
        this.name = getName();
        this.instantPackage = getInstantPackage();
        return this;
    }
    abstract String getInstantPackage();
    abstract String getName();
    @Override
    public String toString() { return "This is a cup of:" + this.name; }


}
