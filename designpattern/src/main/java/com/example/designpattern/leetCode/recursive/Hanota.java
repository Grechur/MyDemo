package com.example.designpattern.leetCode.recursive;

/**
 * @ProjectName: MyDemo
 * @ClassName: Hanota
 * @Description:
 * @Author: Grechur
 * @CreateDate: 2020/6/29 19:36
 */
public class Hanota {
    public static void move(int n,String from,String buffer,String to){
        if(n == 1){
            System.out.println("from"+from+" to"+to);
            return;
        }
        // 将 n-1 个圆盘从 from -> buffer
        move(n-1,from,to,buffer);
        //将 1 个圆盘从 from -> to
        move(1,from,buffer,to);
        // 将 n-1 个圆盘从 buffer -> to
        move(n-1,buffer,from,to);
    }

    public static void main(String[] args) {
//        move(64,"石盘1","石盘2","石盘3");
        int i = 123;
        System.out.println("i>>8="+(i>>8));
        System.out.println("i<<8="+(i<<8));
        int j = Integer.MAX_VALUE;
        System.out.println("j:"+j+" j>>2="+(j>>2));
        System.out.println("j:"+j+" j<<2="+(j<<2));
        int k = Integer.MIN_VALUE;
        System.out.println("k:"+k+" k>>4="+(k>>4));
        System.out.println("k:"+k+" k<<4="+(k<<4));
    }
}
