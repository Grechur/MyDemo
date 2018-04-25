package com.example.designpattern.danic;

/**
 * Created by Zc on 2018/3/13.
 */

public class testb {
    static class Parent{

        public void eat(){
            System.out.println("Parent eat");
        }
    }
    static class Child extends Parent{
        public void eat(){
            System.out.println("child eat");
        }
        public void play(){
            System.out.println("play");
        }
    }

    public static void main(String[] args) {
        Parent parent = new Child();
        parent.eat();

        Child child = new Child();
        child.play();
    }
}
