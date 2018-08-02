package com.example.designpattern;

import java.util.LinkedHashMap;

/**
 * Created by zz on 2018/7/16.
 */

public class DynamicPlan {

    public static void main(String[] args) {
//        System.out.println(Stairs(6));
//        int result = 0;
//        for(int i=1;i<=100;i++){
//            if(isOdd(getFactorNum(i))){
//                result += 1;
//            }
//        }
//        System.out.println(result);
        int[] nums1 = new int[]{4,5,6,0,0,0};
        int[] nums2 = new int[]{1,2,3};
        merge(nums1,3,nums2,3);
        for (int i : nums1) {
            System.out.println(i);
        }

    }

    //走楼梯问题(一次只能走一阶或者2阶)
    public static int Stairs(int n){
        if(n<=0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a+b;
            a = b;
            b = temp;
        }
        return temp;
    }

    //求n约数的个数
    public static int getFactorNum(int n){
        int result = 0;
        for(int i=1;i<=n;i++){
            if(n%i == 0){
                result += 1;
            }
        }
        return result;
    }
    //判断n是否为奇数
    public static boolean isOdd(int n){

        return (n&1) == 1;
    }



//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        if(nums1.length<m+n){
//            return;
//        }
//        if(nums1.length == m+n){
//            for (int i = 0; i < n; i++) {
//                nums1[i] = nums2[i];
//            }
//            return;
//        }
//        int count = m+n-1;
//        int size = n - 1;
//        for (int i = m-1; i >=0 ; i--) {
//            for (int j = size; j >= 0; j--) {
//                if(count>=0) {
//                    if (nums1[i] > nums2[j]) {
//                        nums1[count] = nums1[i];
//                        if(count>0) {
//                            nums1[count - 1] = nums2[j];
//                        }
//                        count--;
//                        break;
//                    } else if (nums1[i] == nums2[j]) {
//                        nums1[count] = nums1[i];
//                        if(count>0) {
//                            nums1[count - 1] = nums2[j];
//                            size--;
//                        }
//                    } else {
//                        nums1[count] = nums2[j];
//                        size--;
//                    }
//                    count--;
//                }
//            }
//        }
//        if(size>0){
//            for (int i = size-1; i >= 0; i--) {
//                nums1[i] = nums2[i];
//            }
//        }
//    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, writeIdx = m + n - 1;
        while (i >= 0 && j >= 0)
            nums1[writeIdx--] = nums1[i] > nums2[j]? nums1[i--] : nums2[j--];
        while (j >= 0)
            nums1[writeIdx--] = nums2[j--];
    }
}
