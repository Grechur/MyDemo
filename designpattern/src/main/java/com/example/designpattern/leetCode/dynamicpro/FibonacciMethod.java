package com.example.designpattern.leetCode.dynamicpro;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: MyDemo
 * @ClassName: FibonacciMethod
 * @Description: 斐波拉契解法
 * @Author: Grechur
 * @CreateDate: 2020/6/29 10:35
 */
public class FibonacciMethod {

    public static void main(String[] args) {
        long last = System.currentTimeMillis();
        map.clear();
        long n = fibonacci3(100);
        long current = System.currentTimeMillis();
        System.out.println("n:" + n +" time:"+(current-last));

    }

    /**
     * 递归
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 备忘录优化递归，使用map来记录前一个数据的数据，当有值时，直接拿，不用重复计算
     */
    static Map<Integer,Long> map = new HashMap<>();
    public static long fibonacci1(int n){
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(map.get(n)!=null){
            return map.get(n);
        }
        long result = fibonacci1(n-1)+fibonacci1(n-2);
        map.put(n,result);
        return result;
    }

    /**
     * 动态规划一：使用一个固定长度数组，将前面的数据保存起来，下一个数直接将前两个数相加
     * @param n
     * @return
     */
    public static long fibonacci2(int n){
        long[] temp = new long[n+1];
        temp[0] = 1;
        temp[1] = 1;

        for (int i = 2; i <= n; i++) {
            temp[i] = temp[i-1]+temp[i-2];
        }
        return temp[n];
    }

    /**
     * 动态规划二：定义三个常量，减少空间复杂度
     * @param n
     * @return
     */
    public static long fibonacci3(int n){
        if(n == 0) return 1;
        if(n == 1) return 2;
        long result = 0;//结果
        long pre = 1;//前2
        long next = 1;//前1
        for (int i = 2; i <= n; i++) {
            result = pre + next;
            pre = next;
            next = result;
        }
        return result;
    }
}
