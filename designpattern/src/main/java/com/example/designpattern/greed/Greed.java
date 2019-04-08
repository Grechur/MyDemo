package com.example.designpattern.greed;

import java.util.ArrayList;
import java.util.List;

public class Greed {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int[] end = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        List<Integer> results = getActionList(start, end);
        for (int i = 0; i < results.size(); i++) {
            int index = results.get(i);
            System.out.println("开始时间:" + start[index] + ",结束时间:" + end[index]);
        }
        List<Integer> result = getActionListByFrame(start,end);
        for (int i = 0; i < result.size(); i++) {
            int index = result.get(i);
            System.out.println("开始时间:" + start[index] + ",结束时间:" + end[index]);
        }


        int[] num = {25,10,5,1};
        int target = 99;
        List<Integer> list = giveMoney(num,target);
        for (int i = 0; i < list.size(); i++) {
            int count = list.get(i);
            System.out.print(num[i]+"硬币个数:" + count +" ");
        }
    }
    /**
     * 设有n个活动的集合e={1，2，…，n}，其中每个活动都要求使用同一资源，如演讲会场等，而在同一时间
     * 内只有一个活动能使用这一资源。每个活动i都有一个要求使用该资源的起始时间si和一个结束时间fi,
     * 且si< fi。如果选择了活动i，则它在半开时间区间[si，fi]内占用资源。若区间[si，fi]与区间[sj，fj]不相交，
     * 则称活动i与活动j是相容的。也就是说，当si≥fi或sj≥fj时，活动i与活动j相容。活动安排问题就是
     * 要在所给的活动集合中选出最大的相容活动子集合。
     * start 活动开始时间集合
     * end   活动结束时间集合
     * 需要保证两个集合按照结束从小到大排序
     */
    public static List<Integer> getActionList(int[] start, int[] end){
        if(start.length != end.length) return null;
        List<Integer> result = new ArrayList<>();
        int endFlag = end[0];
        result.add(0);
        for (int i = 0; i < start.length; i++) {
            if(start[i]>endFlag){
                result.add(i);
                endFlag = end[i];
            }
        }
        return result;
    }
    /**
     * 上个问题用贪心算法的框架来实现
     */
    public static List<Integer> getActionListByFrame(int[] start, int[] end){
        if(start.length != end.length) return null;
        List<Integer> result = new ArrayList<>();
        int endFlag = end[0];
        result.add(0);
        int i = 0;
        while (i<start.length){
            if(start[i]>endFlag){
                result.add(i);
                endFlag = end[i];
            }
            i ++;
        }
        return result;
    }
    /**
     * [找零钱问题]假如老板要找给我99分钱，他有上面的面值分别为25，10，5，1的硬币数
     */
    public static List<Integer> giveMoney(int[] num,int target){
        List<Integer> result = new ArrayList<>();
        int count = num.length;
        for (int i = 0; i < count; i++) {
            result.add(target/num[i]);
            target = target%num[i];
        }
        return result;
    }
}
