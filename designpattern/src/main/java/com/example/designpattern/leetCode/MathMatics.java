package com.example.designpattern.leetCode;

import java.util.ArrayList;
import java.util.List;

public class MathMatics {

    public static void main(String[] args) {
        System.out.println(countPrimes(100));
    }

    /**
     * Fizz Buzz
     *
     写一个程序，输出从 1 到 n 数字的字符串表示。

     1. 如果 n 是3的倍数，输出“Fizz”；

     2. 如果 n 是5的倍数，输出“Buzz”；

     3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     * @param n
     * @return
     */
    public static List<String> fizzBuzz(int n) {
        List<String> array = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(i%3!=0&&i%5!=0){
                array.add(i+"");
            }else if(i%3==0&&i%5!=0){
                array.add("Fizz");
            }else if(i%3!=0&&i%5==0){
                array.add("Buzz");
            }else if(i%3==0&&i%5==0){
                array.add("FizzBuzz");
            }
        }
        return array;
    }

    /**
     * 计数质数
     * 统计所有小于非负整数 n 的质数的数量。
     */

    public static int countPrimes(int n) {
        int number = 0;
        if (n <= 1) return number;
        boolean[] isPrimes = new boolean[n];
        isPrimes[0] = true;
        isPrimes[1] = true;
        for (int i = 2; i*i < n; i++) {
            if(!isPrimes[i]){
                for (int j = i * 2; j < n; j += i) {
                    isPrimes[j] = true;
                }
            }
        }
        for (int i = 0; i < isPrimes.length; i++) {
            if(!isPrimes[i]){
                number ++;
            }
        }
        return number;
    }
}
