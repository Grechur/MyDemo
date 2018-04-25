package com.example.designpattern.factory;

/**
 * Created by Zc on 2018/3/1.
 */

public class PlumJuiceMachine implements IBeverageMachine{
    @Override
    public Drink makeDrink() {
        return new PlumJuice().make();
    }
}
