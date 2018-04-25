package com.example.designpattern;

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
}
