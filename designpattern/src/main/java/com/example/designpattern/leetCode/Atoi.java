package com.example.designpattern.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zz on 2018/7/11.
 */

public class Atoi {
    public static void main(String[] args) {
//        char i = '9';
//        char s = '5';
//        System.out.println((i-s));
        String str = " -15936548658561 ";
        System.out.println(myAtoi(str));
        System.out.println(countAndSay(6));
//        String s = "anagramo", t = "nagaramp";
//        System.out.println(isAnagram(s,t));
//        System.out.println(isAnagram1(s,t));[-1,-2,-3,-4,-5]
//        int[] nums = {-1,-2,-3,-4,-5}; int target = -8;
//        int[] s = twoSum(nums,target);
//        for (int i : s) {
//            System.out.println(i);
//        }
//        int[] nums = {0,1,0,3,12};
//        moveZeroes(nums);
//        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2,0};
//        for (int i : intersect(nums1, nums2)) {
//            System.out.println(i);
//        }

    }
    /**
     * 字符串转整数
     */
    public static int myAtoi(String str) {
        if (str.trim().isEmpty()) return 0;
        int sign = 1, base = 0, i = 0, n = str.length();
        while (i < n && str.charAt(i) == ' ') ++i;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = (str.charAt(i++) == '-') ? -1 : 1;
        }
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;
    }

    public static String countAndSay(int n) {
        if (n <= 0) return "";
        String result = "1";
        if(n==1){
            return result;
        }
        String tmp="";
        while(n>1){
            int index=0;
            char tmpChr;
            while(index < result.length()){
                tmpChr = result.charAt(index);
                int count = 0;

                while(index < result.length() && result.charAt(index) == tmpChr){
                    index ++;
                    count ++;
                }
                tmp = tmp + count + tmpChr;
            }
            result = tmp.toString();
            tmp ="";

            n--;
        }
        return result;
    }


    /**
     * 有效的字母异位词
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        long startTime = System.currentTimeMillis();
        if(s.length() != t.length())
            return false;

        int[] nums1 = new int[256];
        int[] nums2 = new int[256];

        Arrays.fill(nums1, 0);
        Arrays.fill(nums2, 0);
        for(int i = 0 ;i< s.length(); i++){//置零
            nums1[s.charAt(i)]++;
        }

        for(int i = 0 ;i< t.length(); i++){//
            nums2[t.charAt(i)]++;
        }


        for(int i = 0; i < s.length();i++){//比较每个字母出现的次数,相同就是异构
            if(nums1[s.charAt(i)] != nums2[s.charAt(i)]){
                return false;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime)+"时间");
        return true;
    }

    public static boolean isAnagram1(String s, String t) {
        long startTime = System.currentTimeMillis();
        if(s.length() != t.length())
            return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(int i = 0 ;i< s.length(); i++){
            if(map1.get(s.charAt(i))!=null){
                int num = map1.get(s.charAt(i))+1;
                map1.put(s.charAt(i),num);
            }else{
                map1.put(s.charAt(i),1);
            }
        }

        for(int i = 0 ;i< t.length(); i++){//
            if(map2.get(t.charAt(i))!=null){
                int num = map2.get(t.charAt(i))+1;
                map2.put(t.charAt(i),num);
            }else{
                map2.put(t.charAt(i),1);
            }
        }


        for(int i = 0; i < s.length();i++){//比较每个字母出现的次数,相同就是异构
            if(map1.get(s.charAt(i)) != map2.get(s.charAt(i))){
                return false;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime)+"时间");
        return true;
    }

    public static int[] twoSum(int[] nums, int target) {
        int i = 0;
        int right = nums.length-1;
        if((target>0&&nums[right]>target)||(target<0&&nums[right]<target)) right--;
        for (; i < nums.length; i++) {
            int temp = right;
            while (i<temp){
                int count = nums[i]+nums[temp];
                if(count == target){
                    return new int[]{i,temp};
                }
                temp --;
            }
        }
        return new int[]{};
    }

    public static void moveZeroes(int[] nums) {
        int right = nums.length-1;
        for (int i = right; i >=0 ; i--) {
            if(nums[i] == 0){
                int s = i;
                for (int j = s+1; j < nums.length; j++) {
                    int temp = 0;
                    temp = nums[s];
                    nums[s] = nums[j];
                    nums[j] = temp;
                    s++;
                }
            }
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for (int i : nums1) {
            if(map1.get(i)!=null){
                int num = map1.get(i);
                map1.put(i,num);
            }else{
                map1.put(i,1);
            }
        }
        for (int i : nums2) {
            if(map2.get(i)!=null){
                int num = map2.get(i);
                map2.put(i,num);
            }else{
                map2.put(i,1);
            }
        }

        int j = 0;
        int count = nums1.length>nums2.length?nums1.length:nums2.length;
        int[] s = new int[nums1.length<nums2.length?nums1.length:nums2.length];
        for(int i = 0; i < count;i++){
            if(map1.get(nums1.length>nums2.length?nums1[i]:nums2[i]) == map2.get(nums1.length>nums2.length?nums1[i]:nums2[i])){
                s[j] = nums1.length>nums2.length?nums1[i]:nums2[i];
                j++;
            }
        }
        return Arrays.copyOfRange(s, 0, j);
    }
}
