package com.example.designpattern.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: MyDemo
 * @ClassName: CoinsColl
 * @Description: 凑零钱
 * @Author: Grechur
 * @CreateDate: 2020/6/29 14:42
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。输入: coins = [1, 2, 5], amount = 11，输出: 3
 * 解释: 11 = 5 + 5 + 1 输入: coins = [2], amount = 3，输出: -1
 */
public class CoinsColl {

    /**
     * 暴力拆解，倒序拿到最大的硬币
     * @param amount
     * @param coins
     * @return
     */
    public static int coinSum(int amount,int[] coins){
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            amount = amount - coins[i];

            if(amount<0){
                amount = amount + coins[i];//恢复一下
                continue;
            }else{
                count+=1;
                while(amount>=coins[i]){
                    amount = amount - coins[i];
                    count+=1;
                }
            }

            if(amount == 0){
                return count;
            }else if(amount < 0){
                return -1;
            }
        }
        return -1;
    }

    /**
     *递归，时间太长了
     *
     */
    public static int exchange(int amount,int[] coins){
       if(amount == 0){
           return 0;
       }
       if(amount<0){
           return -1;
       }
       int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subMin = exchange(amount-coins[i],coins);
            if(subMin<0) continue;
            result = Math.min(subMin+1,result);
        }
        if(result == Integer.MAX_VALUE){
            return -1;
        }
        return result;
    }

    /**
     * 备忘录
     */
    private static Map<Integer,Integer> map = new HashMap<>();
    public static int exchange1(int amount,int[] coins){
        if(map.get(amount)!=null){
            return map.get(amount);
        }

        if(amount == 0){
            return 0;
        }
        if(amount<0){
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subMin = exchange1(amount-coins[i], coins);
            if(subMin < 0)continue;
            result  = Math.min(subMin+1,result);
        }
        if(result == Integer.MAX_VALUE){
            return -1;
        }
        map.put(amount,result);
        return result;
    }

    public static int exchange2(int amount,int[] coins){
        int[] dp = new int[amount+1];
        // 初始化每个值为 amount+1，这样当最终求得的 dp[amount] 为 amount+1 时，说明问题无解
        for (int i = 0; i < amount + 1; i++) {
            dp[i] = amount+1;
        }
        // 0 硬币本来就没有，所以设置成 0
        dp[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i-coins[j]],dp[i])+1;
                }
            }
        }
        if (dp[amount] == amount + 1) {
            return -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        long last = System.currentTimeMillis();
        int[] coins= {1,2,5};
        int result = coinSum(126,coins);
        long current = System.currentTimeMillis();
        System.out.printf("result :"+result+" time:"+(current-last));
    }
}
