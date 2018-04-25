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
}
