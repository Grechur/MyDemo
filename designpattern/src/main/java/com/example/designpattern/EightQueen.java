package com.example.designpattern;

/**
 * Created by zz on 2018/7/16.
 */

public class EightQueen {
    static final int MAX_NUM = 8;
    int[][] chessBoard = new int[MAX_NUM][MAX_NUM];


    boolean check(int x,int y){
        for (int i = 0; i < y; i++) {
            //检查纵向
            if(chessBoard[x][i] == 1){
                return false;
            }
            //检测左侧斜向
            if(x-1-i>=0&&chessBoard[x-1-i][y-1-i] == 1){
                return false;
            }
            //检测有斜向
            if(x+1+i<MAX_NUM&&chessBoard[x+1+i][y-1-i] == 1){
                return false;
            }
        }
        return true;
    }

    boolean settleQueen(int y){
        //行数如果超过8，说明找出了结果
        if(y == MAX_NUM){
            return true;
        }
        //遍历当前行，逐一格子验证
        for (int i = 0; i < MAX_NUM; i++) {
            //为当前行清零
            for (int x = 0; x < MAX_NUM; x++) {
                chessBoard[x][y] = 0;
            }
            if(check(i,y)){
                chessBoard[i][y] =1;
                if(settleQueen(y+1)){
                    return true;
                }
            }
        }
        return false;
    }
    void printChessBoard(){
        for (int i = 0; i < MAX_NUM; i++) {
            for (int j = 0; j < MAX_NUM; j++) {
                System.out.print(chessBoard[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.settleQueen(0);
        eightQueen.printChessBoard();
    }
}
