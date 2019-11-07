package com.example.designpattern.leetCode;

/**
 * @ProjectName: MyDemo
 * @Package: com.example.designpattern.leetCode
 * @ClassName: JewelsAndStones
 * @Description: 宝石与石头
 * @Author: Grechur
 * @CreateDate: 2019/11/7 17:48
 * @UpdateUser: Grechur
 * @UpdateDate: 2019/11/7 17:48
 */
public class JewelsAndStones {

    public static void main(String[] args) {
//        String J = "aA", S = "aAAbbbb";
        String J = "z", S = "ZZ";
        System.out.println("args = "+numJewelsInStones(J,S));
    }

    public static int numJewelsInStones(String J, String S) {
        int sLength = S.length();
        int jLength = J.length();
        int count = 0;
        for (int i = 0; i < sLength; i++) {
            for (int j = 0; j < jLength; j++) {
                if(S.charAt(i) == J.charAt(j)){
                    count ++;
                }
            }
        }
        return count;
    }
}
