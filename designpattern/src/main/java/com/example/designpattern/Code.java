package com.example.designpattern;

/**
 * Created by Zc on 2018/4/19.
 */

public class Code implements Comparable<Code>{
    public int n;
    public Code(int n){
        this.n = n;
    }

    @Override
    public String toString() {
        return "Code{" +
                "n=" + n +
                '}';
    }

    @Override
    public int compareTo(Code code) {
        if(this.n>code.n){
            return 1;
        }else if (this.n<code.n){
            return -1;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        String s = "1";
        boolean a = Boolean.valueOf(s);
        System.out.println(a);
        String s1 = "true";
        boolean b = Boolean.valueOf(s1);
        System.out.println(b);
    }
}
