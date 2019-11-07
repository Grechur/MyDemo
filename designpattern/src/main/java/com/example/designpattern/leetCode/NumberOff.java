package com.example.designpattern.leetCode;

/**
 * @ProjectName: MyDemo
 * @Package: com.example.designpattern.leetCode
 * @ClassName: NumberOff
 * @Description: 报数
 * @Author: Grechur
 * @CreateDate: 2019/11/5 16:38
 * @UpdateUser: Grechur
 * @UpdateDate: 2019/11/5 16:38
 */
public class NumberOff {

    public static void main(String[] args) {
        System.out.println(countAndSaySelf(7));
    }

    public static String countAndSayYear(int n) {
        if (n <= 0) return "";
        String result = "1";
        if(n==1){
            return result;
        }
        String tmp="";
        while(n>1){
            int index=0;
            char tmpChr;
            while(index < result.length()){
                tmpChr = result.charAt(index);
                int count = 0;

                while(index < result.length() && result.charAt(index) == tmpChr){
                    index ++;
                    count ++;
                }
                tmp = tmp + count + tmpChr;
            }
            result = tmp.toString();
            tmp ="";

            n--;
        }
        return result;
    }

    /**
     * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
     *
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 6.     312211
     * 7.     13112221
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     *
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
     *
     * 注意：整数顺序将表示为一个字符串。
     * 我的想法是使用移动窗口的方式，从start开始，查找与当前文字相同的end文字，下一个start从end+1开始
     * @param n
     * @return
     */
    public static String countAndSaySelf(int n) {
        if(n == 1) return "1";
        n = n-1;
        StringBuffer stringBuffer = new StringBuffer("1");
        while (n>0){//这个循环是用于做n次数判断的
            int start = 0,end = 0;//定义窗口的起始和结束
            StringBuffer tempSb = new StringBuffer();
            int length = stringBuffer.length();
            Character character = null;
            while (start<length&&end<length){//判断下标越界的
                character = stringBuffer.charAt(start);//拿到初始的字符
                if (character.equals(stringBuffer.charAt(end))){//如果窗口中字符相同
                    end++;//移动结束下标
                }else{//如果不相同，将前一次的纪录下来
                    tempSb.append((end-start)+character.toString());
                    start = end;//将开始下标移动到结束下标的地方，重新下一个字符读取
                }
            }
            tempSb.append((end-start)+character.toString());//读取完，拼接最后一个字符读取
            stringBuffer = tempSb;
            n--;
        }

        return stringBuffer.toString();
    }


    /**
     * 牛人的解答
     * 其实思路也是
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        String s="1";
        for(int i=1;i<n;i++){
            s=read_string(s);
        }
        return s;
    }
    public static String read_string(String s){
        StringBuilder res=new StringBuilder("");
        int flag=0;//目标字符位置
        for(int i=0;i<s.length();i++){//判断下标小于输入的文字长度
            if(s.charAt(i)!=s.charAt(flag)){//如果移动下标字符与目标字符不同
                res.append(""+(i-flag)+s.charAt(flag));//纪录上一个字符读取情况
                flag=i;//移动到下一个字符位置
            }
        }
        res.append(""+(s.length()-flag)+s.charAt(flag));
        return res.toString();
    }
}
