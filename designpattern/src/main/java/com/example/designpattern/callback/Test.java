package com.example.designpattern.callback;

/**
 * Created by Zc on 2018/3/12.
 */

public class Test {
    public static void main(String[] args) {
        Li li = new Li();
        Wang wang = new Wang(li);
        wang.askQuestion("1+3=?");
    }
}
