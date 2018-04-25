package com.example.designpattern.simplefactory;

/**
 * Created by Zc on 2018/3/1.
 */

public class CousinsFactory {
    public static Drink create(String drinkType){
        switch (drinkType) {
            case "橙汁":
                return new OrangeJuice();
            case "酸梅汤":
                return new PlumJuice();
            case "可乐":
                return new Coke();
            default:
                return new OrangeJuice();
        }
    }
}
