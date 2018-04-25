package com.example.designpattern.stuff;

/**
 * Created by Zc on 2018/3/1.
 */

public class Ice extends Stuff{

    public Ice(Drink joinDrink) {
        super(joinDrink);
    }

    @Override
    String stuffName() {
        return "冰";
    }
}
