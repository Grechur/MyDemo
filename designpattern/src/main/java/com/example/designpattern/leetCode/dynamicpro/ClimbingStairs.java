package com.example.designpattern.leetCode.dynamicpro;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: MyDemo
 * @ClassName: ClimbingStairs
 * @Description: 爬楼梯
 * @Author: Grechur
 * @CreateDate: 2020/6/29 18:04
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbingStairs {

    public static int stairs(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        return stairs(n-1)+stairs(n-2);
    }

    private static Map<Integer,Integer> map = new HashMap<>();
    public static int stairs1(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(map.get(n)!=null){
            return map.get(n);
        }
        int result = stairs(n-1)+stairs(n-2);
        map.put(n,result);
        return result;
    }

    public static int stairs2(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static int stairs3(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int result = 0;
        int pre = 1;
        int repre = 2;
        for (int i = 3; i <= n; i++) {
            result = pre + repre;
            pre = repre;
            repre = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("stairs:"+stairs3(10));;
    }
}
