package com.example.designpattern.leetCode;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        System.out.println("----------------从排序数组中删除重复项---------------------");
        int[] nums = {0,0,1,1,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println("----------------买卖股票的最佳时机 II---------------");
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
        System.out.println("----------------旋转数组--------------");
        int[] rotates = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(rotates,k);
        for (int rotate : rotates) {
            System.out.print(rotate +"  ");
        }
        System.out.println("");
        System.out.println("----------------存在重复--------------");
        System.out.println(containsDuplicate(nums));
        System.out.println("----------------只出现一次的数字--------------");
        int[] doubles = {4,1,2,1,2};
        System.out.println(singleNumber(doubles));
        System.out.println("----------------两个数组的交集 II--------------");
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        int num[] =intersect(nums1,nums2);
        for (int i : num) {
            System.out.print(i+" ");
        }
        System.out.println("");
    }

    /**
     * 从排序数组中删除重复项
     * 思路：判断不相同,移动数组下标，将不相同的值移动到当前的下标位置，一直遍历到结尾。
     */
    public static int removeDuplicates(int[] nums){
        int len = nums.length;
        if(len == 0) return 0;
        int number = 0;
        for (int i = 0; i < len; i++) {
            if(nums[number] != nums[i]){
                number ++;
                nums[number] = nums[i];
            }
        }
        number += 1;
        return number;
    }

    /**
     * 买卖股票的最佳时机 II
     * 思路:先把第一个元素作为最小值，当有比它大的就计算累计获得收益，同时交换最小值，比它小就直接交换值，
     */
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        int maxSum = 0;
        int minPrice = prices[0];
        for (int i = 0; i < len; i++) {
            if(prices[i]>minPrice){
                maxSum += prices[i] - minPrice;
            }
            minPrice = prices[i];
        }
        return maxSum;
    }

    /**
     * 旋转数组
     *
     */
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        if(len == 0) return;
        k = k % len;
        resever(nums,0,len-1);//反转整个数组
        resever(nums,0,k-1);//逆序前K个元素
        resever(nums,k,len-1);//逆序剩余元素
    }
    public static void resever(int[] nums,int start,int end){
        while (start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    /**
     * 存在重复
     * 思路：先使用排序，相同的元素会排在一起，，如果相同就说明有重复的
     */
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if(len == 0) return false;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
    /**
     * 只出现一次的数字
     * 这个思路是通过数学中异或“^ ”的来完成的
     * 异或操作，两个相同的数异或结果为0，一个数跟0异或是这个数本身。
     * A^B^B = A
     */
    public static int singleNumber(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int result = 0;
        for (int num : nums) {
            result = result^num;
        }
        return result;
    }

    /**
     * 两个数组的交集 II
     * 思路：首先通过最小数组来确定接收数组的大小，给两个数组排序后，从第一个数字遍历，
     * 相等时同时移动下标，避免出现重复数字
     * 不等时，数值小的移动下标，在比较
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 == 0||len2 == 0) return new int[]{};
        int len = len1>len2?len2:len1;
        int[] num = new int[len];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int k = 0;
        int current1,current2;
        for (int i= 0,j=0;i<len1&&j<len2;){
            current1 = nums1[i];
            current2 = nums2[j];
            if(current1 == current2){
                num[k] = current1;
                k += 1;
                i += 1;
                j += 1;
            }else if(current1<current2){
                i += 1;
            }else{
                j += 1;
            }
        }

        return Arrays.copyOfRange(num, 0, k);
    }
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {

        }
        return true;
    }
}
