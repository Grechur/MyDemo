package com.example.designpattern.superorextends;

/**
 * Created by Zc on 2018/3/12.
 */

public class Test2 {
    private String aa = "Test2";
    public Test2(){
        speak();
    }

    private void speak() {
        System.out.println(aa);
    }
    static class Stub extends Test2{
        private String aa = "Stub";
        private void speak() {
            System.out.println(aa);
        }
    }

    public static void main(String[] args) {

        Test2 test2 = new Stub();
    }
}
