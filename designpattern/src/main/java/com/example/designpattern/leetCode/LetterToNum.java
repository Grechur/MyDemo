package com.example.designpattern.leetCode;

/**
 * @ProjectName: MyDemo
 * @Package: com.example.designpattern.leetCode
 * @ClassName: LetterToNum
 * @Description: 字母转数字
 * @Author: Grechur
 * @CreateDate: 2019/11/7 16:40
 * @UpdateUser: Grechur
 * @UpdateDate: 2019/11/7 16:40
 */
public class LetterToNum {


    public static void main(String[] args) {
            System.out.println("result = "+change("CBAA"));
    }

    /**
     * 字母转数字
     * A        1
     * B        2
     *
     * AA       27
     * AB       28
     *
     * YZ       701
     * @param s
     * @return
     */
    public static int change(String s){
        s = s.toUpperCase();
        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - 'A' +1;//是以字母'A'作为标准的，所以要将字母变为标准数字
            result = result*26+num;
        }
        return result;
    }
}
