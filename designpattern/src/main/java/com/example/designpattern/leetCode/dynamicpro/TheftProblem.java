package com.example.designpattern.leetCode.dynamicpro;

/**
 * @ProjectName: MyDemo
 * @ClassName: TheftProblem
 * @Description: 打家劫舍问题
 * @Author: Grechur
 * @CreateDate: 2020/6/29 16:52
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装
 * 有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 */
public class TheftProblem {

    public static int theft(int[] money){
        if(money.length == 0){
            return 0;
        }
        int size = money.length;
        int[] dp = new int[size+1];
        dp[0] = 0;
        dp[1] = money[0];
        for (int i = 2; i <= size; i++) {
//            int pre = dp[i-1];
//            int repre = dp[i-2]+money[i-1];
//            System.out.println("pre:"+pre+" repre:"+repre);
            dp[i] = Math.max(dp[i-1],dp[i-2]+money[i-1]);
        }
        return dp[size];
    }

    public static int theft1(int[] money){
        int pre = 0;
        int current = 0;
        for (int i : money) {
            int result = Math.max(current,pre+i);
            pre = current;
            current = result;
        }
        return current;
    }

    public static void main(String[] args) {
        int[] money = {1,2,3,1,1,1,1,9,1,3,6,4};
        System.out.printf("theft:"+theft1(money));
    }
}
