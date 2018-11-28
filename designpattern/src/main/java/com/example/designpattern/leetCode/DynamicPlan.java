package com.example.designpattern.leetCode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

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
//        int[] nums1 = new int[]{4,5,6,0,0,0};
//        int[] nums2 = new int[]{1,2,3};
//        merge(nums1,3,nums2,3);
//        for (int i : nums1) {
//            System.out.println(i);
//        }
//        List<String> s = fizzBuzz(15);
//        for (int i = 0; i < s.size(); i++) {
//            System.out.println(s.get(i));
//        }

        isPowerOfThree(9);
    }

    //走楼梯问题(一次只能走一阶或者2阶)
    public static int Stairs(int n){
//        if(n<=0) return 0;
//        if(n == 1) return 1;
//        if(n == 2) return 2;
//        int a = 1;
//        int b = 2;
//        int temp = 0;
//        for (int i = 3; i <= n; i++) {
//            temp = a+b;
//            a = b;
//            b = temp;
//        }

        if (n == 0)
            return 1;
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    public static int feibo(int n){
        if(n==0) return 1;
        if(n==1) return 1;
        int[] array = new int[n+1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i-1]+array[i-2];
        }
        return array[n];
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


    public static List<String> fizzBuzz(int n) {
        List<String> array = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(i%3!=0&&i%5!=0){
                array.add(i+"");
            }else if(i%3==0&&i%5!=0){
                array.add("Fizz");
            }else if(i%3!=0&&i%5==0){
                array.add("Buzz");
            }else if(i%3==0&&i%5==0){
                array.add("FizzBuzz");
            }
        }
        return array;
    }

    public static boolean isPowerOfThree(int n) {
        double tem = Math.log10(n) / Math.log10(3);
        System.out.println(tem);
        return (tem - (int)(tem)) == 0?true:false;
    }


    public static int maxSubArray(int[] nums) {// 动态规划法
        int sum=nums[0];
        int n=nums[0];
        for(int i=1;i<nums.length;i++) {
            if(n>0)n+=nums[i];
            else n=nums[i];
            if(sum<n)sum=n;
        }
        return sum;
    }

}
