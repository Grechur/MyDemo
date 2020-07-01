package com.example.designpattern.sort;

import java.util.Arrays;

/**
 * @ProjectName: MyDemo
 * @ClassName: SimpleSort
 * @Description:
 * @Author: Grechur
 * @CreateDate: 2020/6/24 16:06
 */
public class SimpleSort {

    public static void main(String[] args) {
        int[] num = {1,5,4,9,3,2};
//        int[] ints = bubbleSort(num);
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println("i:"+num[i]);
//        }
//        int[] ints = selectSort(num);
//        for (int anInt : ints) {
//            System.out.println("i:"+anInt);
//        }
//        insertSort(num);
//        for (int i : num) {
//            System.out.println("i: " + i);
//        }
    }
    /**
     *冒泡排序
     */
    public static int[] bubbleSort(int[] num){
        int size = num.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <size-i-1 ; j++) {
                int temp;
                if(num[j]>num[j+1]){
                    temp = num[j];
                    num[j] = num[j+1];
                    num[j+1]=temp;
                }
            }
        }
        return num;
    }

    /**
     *  选择排序
     */
    public static int[] selectSort(int[] num){
        for (int i = 0; i < num.length; i++) {
            int min = i;
            for (int j = i+1; j < num.length; j++) {
                if(num[j]<num[min]){
                    min = j;
                }
                int temp;
                temp = num[i];
                num[i] = num[min];
                num[min] = temp;
            }
        }
        return num;
    }

    /**
     *插入排序
     */
    public static int[] insertSort(int[] num){
        for (int i = 1; i < num.length; i++) {
            int j = i;
            int temp=num[i];
            while (j>0&&temp<num[j-1]){
                num[j] = num[j-1];
                j--;
            }
            if(j!=i) num[j]=temp;
        }
        return num;
    }
}
