package com.example.designpattern;

/**
 * Created by Zc on 2018/3/19.
 */

public class BiSearch {
    public static int biSearch(int[] array,int a){
        int low = 0;
        int h = array.length-1;
        int mid;
        while (low<=h) {
            mid = (low+h)/2;//中轴位置是最大和最小的一半的地方
            if(array[mid] == a){//中轴正好是a，直接返回这个位置
                return mid+1;
            } else if(array[mid]<a){//a比中轴大，则a在后半段，将最小值移到中轴后一位
                low = mid + 1 ;
            } else{//a比中轴小，则a在前半段，将最大值移到中轴前一位
                h = mid - 1;
            }
        }
        return -1;//没有找到
    }


    public static void main(String[] args) {
        int[] num = {1,5,6,8,10,16,18};
        int i = biSearch(num,16);
        System.out.println(i+"");
    }

}
