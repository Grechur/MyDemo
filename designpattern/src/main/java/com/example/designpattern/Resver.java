package com.example.designpattern;

import com.example.designpattern.callback.Li;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Zc on 2018/3/13.
 */

public class Resver {
    public static void main(String[] args) {
//        Book book = new Book();
//        book.id = 2;
//        book.name = "nihao";
//        book.price = 10;
//
//        Book book1 = new Book();
//        book.id = 1;
//        book.name = "quba";
//        book.price = 15;
//
//        Book book2 = new Book();
//        book.id = 3;
//        book.name = "gun";
//        book.price = 15;
//
//        List<Book> books = new ArrayList<>();
//        books.add(book);
//        books.add(book1);
//        books.add(book);
//        books.add(book2);
//
//        for(Book b:books){
//            System.out.print(b.toString());
//        }
//        System.out.println("----------------------");
//        Set<Book> bookSet = new HashSet<>(books);
//
//        List<Book> bookList = new ArrayList<>(bookSet);
//        for(Book b:bookList){
//            System.out.println(b.toString());
//        }

//        int[] nums = {4,7,2,1,9,0};
//        int low = 0;
//        int high = nums.length-1;
//        quickSort(nums,low,high);
//        for (int num : nums) {
//            System.out.println(num);
//        }

        int n = 4;
        int num[] = new int[n+1];


        System.out.println(fib(n,num));
        System.out.println("--------------");
        for (int i : num) {
            System.out.println(i);
        }

    }

    /**
     * 快速排序
     * @param nums
     * @param low
     * @param high
     */
    public static void quickSort(int[] nums,int low,int high){
        if(low<high){
            int middle = quickPass(nums,low,high);
            quickSort(nums,low,middle-1);
            quickSort(nums,middle+1,high);
        }
    }

    /**
     * 查找中心点
     * @param nums
     * @param low
     * @param high
     * @return
     */
    private static int quickPass(int[] nums, int low, int high) {
        int temp = nums[low];
        while (low<high){
            while (low<high&&nums[high]>=temp) {high--;}
            nums[low] = nums[high];
            while (low<high&&nums[low]<=temp) {low++;}
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }


    public static int fib(int n,int[] nums) {

        if(n==0) nums[n] = 1;
        if(n == 1) nums[n] = 1;
        if(n>1){
            nums[n] = fib(n-1,nums) + fib(n-2,nums);
        }
        return nums[n];
    }

}
