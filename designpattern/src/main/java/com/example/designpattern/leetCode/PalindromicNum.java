package com.example.designpattern.leetCode;

/**
 * @ProjectName: MyDemo
 * @Package: com.example.designpattern.leetCode
 * @ClassName: PalindromicNum
 * @Description: 回文数
 * @Author: Grechur
 * @CreateDate: 2019/11/5 10:52
 * @UpdateUser: Grechur
 * @UpdateDate: 2019/11/5 10:52
 */
public class PalindromicNum {

    public static void main(String[] args) {
        isPalindrome(1234321);
    }

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 示例 1:
     *
     * 输入: 121
     * 输出: true
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x==0) return true;
        if(x<0||x%10==0){//负数肯定不是回文数，结尾位0的数也肯定不是
            return false;
        }
        int reserveNum = 0;
        while (x>reserveNum){//判断x除10取整之后是否大于后半部反转的数
            //通过模运算，逐步将x后部分的数反转
            //x = 123432 reserveNum =1
            //x = 12343 reserveNum =12
            //x = 1234 reserveNum =123
            //x = 123 reserveNum =1234
            reserveNum = reserveNum * 10 + x % 10;
            x /= 10;
            System.out.println("x = " + x + " reserveNum ="+reserveNum);
        }
        //当初始x长度是奇数时，需要将最后一位去掉在作比较
        return x==reserveNum||x==reserveNum/10;
    }
}
