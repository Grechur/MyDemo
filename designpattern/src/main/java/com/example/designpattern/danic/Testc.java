package com.example.designpattern.danic;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Zc on 2018/3/13.
 */

public class Testc {
    static class Parent{
        private final String aa = "Parent";
        public Parent(){
            play();
        }
        protected void play(){
            System.out.println(aa);
        }
    }
    static class Child extends Parent{
        private final String aa = "Child";
        public void play(){
            super.play();
            System.out.println(aa);
        }
    }

    public static void main(String[] args)
    {
        Parent p = new Child();

        List a = new ArrayList();
        a.add(1);
        a.add(2);
        a.add(3);
        int size = a.size();
//        int mid = size>>1;
//        for (int i = 0;i<mid;i++){
//            for (int j = size-1;j>=0;j--){
//                swap(a, i, j);
//            }
//        }
//        int mid;
        for (int i=0, mid=size>>1, j=size-1; i<mid; i++, j--)
            swap(a, i, j);
    }
    public static void swap(List<?> list, int i, int j) {
        // instead of using a raw type here, it's possible to capture
        // the wildcard but it will require a call to a supplementary
        // private method
        final List l = list;
//        l.set(j,l.get(i));
//        System.out.println("list1 = [" + l + "], i = [" + i + "], j = [" + j + "]");
        l.set(i, l.set(j, l.get(i)));
        System.out.println("list2 = [" + l + "], i = [" + i + "], j = [" + j + "]");
    }
}
