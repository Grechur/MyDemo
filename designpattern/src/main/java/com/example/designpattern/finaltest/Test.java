package com.example.designpattern.finaltest;

/**
 * Created by zhouzhu on 2018/7/24.
 */

public class Test {
    final User user =new User();
    final String use;
    public Test(){
        user.setAge(10);
        user.setName("aa");
        use = "nihao";
    }
    public static void main(String[] args) {
        Test test =new Test();
        System.out.println(test.user.toString());
        User user1 = new User();
        user1.setAge(20);
        user1.setName("bb");
        System.out.println(test.user.toString());
    }
}
