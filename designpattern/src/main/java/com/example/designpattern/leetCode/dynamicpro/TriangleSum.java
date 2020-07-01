package com.example.designpattern.leetCode.dynamicpro;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: MyDemo
 * @ClassName: TriangleSum
 * @Description: 三角形的最小路径和
 * @Author: Grechur
 * @CreateDate: 2020/6/29 11:37
 */
public class TriangleSum {
//    private static int[][] triangle = {
//            {2,0,0,0},
//            {3,4,0,0},
//            {6,5,7,0},
//            {4,1,8,9}
//    };

    /**
     * 递归
     * @param i
     * @param j
     * @return
     */
    public static int sum(int i,int j){
        int totalRow = 4; // 总行数
        if (i >=  totalRow - 1) {
            return 0;
        }

        int left = sum(i+1,j)+triangle[i+1][j];
        int right = sum(i+1,j+1)+triangle[i+1][j+1];
        return Math.min(left,right);
    }

    /**
     * 备忘录优化
     */
    public static Map<String,Integer> map = new HashMap<>();
    public static int sum1(int i,int j){
        String key = i+""+j;
        if(map.get(key)!=null){
            return map.get(key);
        }
        int totalRow = 4;
        if(i>=totalRow-1){
            return 0;
        }
        int left = sum1(i+1,j)+triangle[i+1][j];
        int right = sum1(i+1,j+1)+triangle[i+1][j+1];
        int result = Math.min(left,right);
        map.put(key,result);
        return result;
    }

    private static int[][] triangle = {
            {2, 0, 0, 0},
            {3, 4, 0, 0},
            {6, 5, 7, 0},
            {4, 1, 8, 3}
    };
    public static int traverse() {
        int ROW = 4;
        int[] mini = triangle[ROW - 1];
        // 从倒数第二行求起，因为最后一行的值本身是固定的
        for (int i = ROW - 2; i >= 0; i--) {
            for (int j = 0; j < ROW; j++) {
                if(j+1<ROW) {
                    mini[j] = triangle[i][j] + Math.min(mini[j], mini[j + 1]);
                }
            }
        }
        return mini[0];
    }

    public static  void main(String[] args)  throws Throwable {
        int minPathSum = traverse();
        System.out.println("sum = " + minPathSum);
    }

}
