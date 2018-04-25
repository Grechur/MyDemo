package com.example.designpattern.danic;

/**
 * Created by Zc on 2018/3/6.
 */

public class testa {
    static class A {
        public String show(D obj){
            return ("A and D");
        }
        public String show(A obj){
            return ("A and A");
        }
    }
    static class B extends A{
        public String show(B obj){
            return("B and B");
        }
        public String show(A obj){
            return("B and A");
        }
    }
    static class C extends B{}
    static class D extends B{}

    public static void main(String[] args) {
        A a1=new A();
        A a2=new B();
        B b=new B();
        C c=new C();
        D d=new D();
        System.out.println("1--"+a1.show(b));
        System.out.println("2--"+a1.show(c));
        System.out.println("3--"+a1.show(d));
        System.out.println("4--"+a2.show(b));
        System.out.println("5--"+a2.show(c));
        System.out.println("6--"+a2.show(d));
        System.out.println("7--"+b.show(b));
        System.out.println("8--"+b.show(c));
        System.out.println("9--"+b.show(d));
        System.out.println("10--"+a2.show(a1));
        System.out.println("11--"+c.show(d));
    }
}
