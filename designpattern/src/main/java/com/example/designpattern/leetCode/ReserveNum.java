package com.example.designpattern.leetCode;

/**
 * @ProjectName: MyDemo
 * @Package: com.example.designpattern.leetCode
 * @ClassName: ReserveNum
 * @Description: 整数反转
 * @Author: Grechur
 * @CreateDate: 2019/11/5 11:25
 * @UpdateUser: Grechur
 * @UpdateDate: 2019/11/5 11:25
 */
public class ReserveNum {

    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
        int x = reverse(i);
        System.out.println("i = " + i + "x = "+x);
    }

    /**
     * 数字的反转很容易，一般都是将原数字通过循环取余操作获取最后一位
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int result = 0;
        while (x!=0){
            if(result>Integer.MAX_VALUE/10)return 0;
            if(result<Integer.MIN_VALUE/10)return 0;
            result = result*10+x%10;
            x /= 10;
        }
        return result;
    }
}
