package com.example.designpattern;

import java.text.DecimalFormat;

/**
 * Created by Zc on 2018/4/2.
 */

public class Book {
    public String name;
    public int id;
    public int price;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        int num = 45216987;
        System.out.println("numToString:"+numToString(num));
    }

    public static String numToString(int number){
        String num = "";
        DecimalFormat df = new DecimalFormat("0.0");
        if(number>0&&number<10000){
            num += number+"";
        }else if(number>=10000&&number<100000000){
            num += df.format((float)number/10000)+"万";
        }else{
            num += df.format((float)number/100000000)+"亿";
        }
        return num;
    }
}
