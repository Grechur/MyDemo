package com.example.designpattern;

/**
 * Created by zz on 2018/7/19.
 */

public class Sort {
    public static void main(String[] args) {
        int[] in = {54,32,45,87,12,95,56,32,15,0,25};
        int count = in.length;
        int low=0;
        int high=count-1;

//        QKSort(in,low,high);
//        maopao(in);
        selectionsort(in,count);
        for (int i = 0; i < count; i++) {
            System.out.println(in[i]+"");
        }
    }

    private static void QKSort(int[] in, int low, int high) {
        int pos = 0;
        if(low<high){
            pos = QKpass(in,low,high);
            QKSort(in,low,pos-1);
            QKSort(in,pos+1,high);
        }

    }

    private static int QKpass(int[] in, int low, int high) {
        int temp = in[low];
        while(low<high){
            while(low<high && in[high]>=temp){
                high--;
            }
            in[low] = in[high];
            // System.out.println(in[low]);
            //low++;
            while(low<high && in[low]<=temp){
                low++;
            }
            in[high] = in[low];
            // System.out.println(in[high]+"FF");
            // high--;
        }

        in[low] = temp;
        return low;
    }


    private static void maopao(int[] in){
        for (int i = 0; i < in.length-1; i++) {
            for (int j = 0; j < in.length-i-1; j++) {
                if(in[j]>in[j+1]){
                    int temp = in[j];
                    in[j] = in[j+1];
                    in[j+1] = temp;
                }
            }
        }
    }

    private static void selectionsort(int arrayVal[],int length)
    {
        int i,j,max;
        int temp;

        for(j=length;j>1;j--)
        {
            max=0;//标记最值位置
            for(i=1;i<j;i++)
                if(arrayVal[i]>=arrayVal[max])
                    max=i;
            if(max!=j-1)
            {
                temp=arrayVal[max];
                arrayVal[max]=arrayVal[j-1];
                arrayVal[j-1]=temp;
            }
        }

    }
}
