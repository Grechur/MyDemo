package com.example.designpattern.leetCode;

/**
 * @ProjectName: MyDemo
 * @Package: com.example.designpattern.leetCode
 * @ClassName: BalancedSplit
 * @Description: 分割平衡字符串
 * @Author: Grechur
 * @CreateDate: 2019/11/12 15:39
 * @UpdateUser: Grechur
 * @UpdateDate: 2019/11/12 15:39
 */
public class BalancedSplit {

    public static void main(String[] args) {
        String s = "RLRLRRLRL";
        System.out.println("result = "+balancedStringSplit(s));
    }

    public static int balancedStringSplit(String s) {
        int num = 0;
        int result = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            if(s.charAt(i) == 'R')
                num ++;
            if(s.charAt(i) == 'L')
                num --;

            if(num == 0){
                result ++;
            }
        }

        return result;
    }
}
