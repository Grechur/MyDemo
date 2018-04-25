package com.example.designpattern.prototype;

import java.util.ArrayList;

/**
 * Created by Zc on 2018/3/1.
 * 由于原型模式较为通用, 且相对简单, Java中的最基类Object已经提供了clone方法, 来方便我们复制出新的对象实例.
 */

public class Company implements Cloneable{
    private ArrayList<String> drinks = new ArrayList<>();
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addDrink(String drink) {
        drinks.add(drink);
    }

    @Override
    protected Company clone() {

        Company company = null;
        try {
            company = (Company) super.clone();
            // 对于对象的属性也加以clone
            company.drinks = (ArrayList<String>) this.drinks.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public String toString() {
        return "Company{" +
                "名字='" + name + '\'' +
                ", 饮品=" + drinks +
                '}';
    }
}
