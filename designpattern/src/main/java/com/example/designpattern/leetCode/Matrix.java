package com.example.designpattern.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: MyDemo
 * @Package: com.example.designpattern.leetCode
 * @ClassName: Matrix
 * @Description: 螺旋矩阵 II
 * @Author: Grechur
 * @CreateDate: 2019/11/12 15:57
 * @UpdateUser: Grechur
 * @UpdateDate: 2019/11/12 15:57
 */
public class Matrix {

    public static void main(String[] args) {
        int[][] result = generateMatrix(1);

        int[][] input = new int[4][3];
        int v = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <3; j++) {
                input[i][j] = v++;
            }
        }

        List<Integer> list = spiralOrder(input);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }

    /**
     * 输入: 3
     * 输出:
     * [
     *  [ 1, 2, 3 ],
     *  [ 8, 9, 4 ],
     *  [ 7, 6, 5 ]
     * ]
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int v = 1;
        for (int i = 0; i < n/2; i++) {
            //设置二维数组为x轴和y轴，将一个面的最后一个留下了，当作下一个面的初始
            //在一次循环中，i及与i相关运算的值是不变的，j是小循环的值，一直变动
            //所以在四面的计算时，需要注意x轴和y轴的变化情况
            for(int j=i;j<n-i-1;j++) {
                result[i][j] = v++;//上部分是x不变，y递增，
            }
            for(int j=i;j<n-i-1;j++) {
                result[j][n-i-1] = v++;//右部分是y不变，x递增
            }
            for (int j=n-i-1;j>i;j--) {
                result[n-i-1][j] = v++;//下部分是x不变，y递减
            }
            for (int j=n-i-1;j>i;j--) {//左部分是y不变，x递减
                result[j][i] = v++;
            }
        }
        if(n%2 == 1) result[n/2][n/2] = n*n;//如果是奇数，最后一个位置设值
        return result;
    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return result;
        int m = matrix.length;//Y轴4
        int n = matrix[0].length;//X轴3

        int r = (Math.min(m,n)+1)/2;

        for (int i = 0; i < r; i++) {
            //x =3,y=4     n=3 X轴,m=4 Y轴
            for (int j = i; j < n - i; j++) {//0,1
                result.add(matrix[i][j]);
            }

            for (int j = i+1; j < m - i; j++) {//0,1,2
                result.add(matrix[j][(n - 1) - i]);
            }

            for (int j = (n-1) - i - 1; j >= i && (m - 1 - i) != i; j--) {
                result.add(matrix[m - i - 1][j]);
            }

            for (int j = (m-1) - i - 1; j >= i+1 && (n - 1 - i) != i; j--) {
                result.add(matrix[j][i]);
            }
        }
        return result;
    }

    public static List<Integer> spiralOrderl(int[][] matrix){
        List<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
            return list;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;

        //统计矩阵从外向内的层数，如果矩阵非空，那么它的层数至少为1层
        int count = (Math.min(m, n)+1)/2;
        //从外部向内部遍历，逐层打印数据
        while(i < count) {
            for (int j = i; j < n-i; j++) {
                list.add(matrix[i][j]);
            }
            for (int j = i+1; j < m-i; j++) {
                list.add(matrix[j][(n-1)-i]);
            }

            for (int j = (n-1)-(i+1); j >= i && (m-1-i != i); j--) {
                list.add(matrix[(m-1)-i][j]);
            }
            for (int j = (m-1)-(i+1); j >= i+1 && (n-1-i) != i; j--) {
                list.add(matrix[j][i]);
            }
            i++;
        }
        return list;

    }
}
