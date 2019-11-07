package com.example.designpattern.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: MyDemo
 * @Package: com.example.designpattern.leetCode
 * @ClassName: MaxString
 * @Description: 无重复字符的最长子串
 * @Author: Grechur
 * @CreateDate: 2019/10/31 12:01
 * @UpdateUser: Grechur
 * @UpdateDate: 2019/10/31 12:01
 */
public class MaxString {

    public static void main(String[] args) {
        String s = "adweyuiolkdsafgdbsdgjklydqwdfklsahgjdjal;gjoigjksanhkjdasnmdnakjgdnsafndjkashgdanmabhkjasndnkjcashvdasklndjkashdsanvdaskjhdjandmasndkasnm,bkanbm,hvlnaslbnsa";
        System.out.println("list--result=="+lengthOfLongestSubstringList(s));
        System.out.println("set--result=="+lengthOfLongestSubstringSet(s));
        System.out.println("map--result=="+lengthOfLongestSubstringMap(s));
    }

    /**
     * 思路：使用窗口模式，纪录下开始字符和结束字符，当包含结束字符时，删除和结束字符相同的开始字符之前的字符，从相同字符下一个字符开始算
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringList(String s) {
        int n = s.length();
        int res = 0;
        int end=0,start=0;
        List<Character> set=new ArrayList<>();
        while(start<n && end<n){
            if(set.contains(s.charAt(end))){
                //当包含重复结束字符时，移动开始字符的位置，删除掉重复字符及之前的字符
                Character character = s.charAt(start++);
                set.remove(character);
            }else{
                //不包含重复字符时，将字符加入到集合中
                set.add(s.charAt(end++));
                //将当前的字符长度和前一次的字符长度比较，纪录下最长的字符的长度
                res=Math.max(res,end-start);
            }
        }
        return res;

    }

    public static int lengthOfLongestSubstringSet(String s) {
        int n = s.length();
        int res = 0;
        int end=0,start=0;
        Set<Character> set=new HashSet<>();
        while(start<n && end<n){
            if(set.contains(s.charAt(end))){
                //当包含重复结束字符时，移动开始字符的位置，删除掉重复字符及之前的字符
                set.remove(s.charAt(start++));
            }else{
                //不包含重复字符时，将字符加入到集合中
                set.add(s.charAt(end++));
                //将当前的字符长度和前一次的字符长度比较，纪录下最长的字符的长度
                res=Math.max(res,end-start);
            }
        }
        return res;

    }

    public static int lengthOfLongestSubstringMap(String s){
        int n = s.length();
        int result = 0,start = 0,end = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(;start<n && end<n;end++){
            if(map.containsKey(s.charAt(end))){
              start =  Math.max(map.get(s.charAt(end)),start);
            }
            map.put(s.charAt(end),end+1);
            result = Math.max(result,end-start+1);
        }
        return result;
    }
}
