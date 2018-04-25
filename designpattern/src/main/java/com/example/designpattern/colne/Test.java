package com.example.designpattern.colne;

import com.example.designpattern.Code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Zc on 2018/4/17.
 */

public class Test {
    public static void main(String[] args) {
//        ShallowCloneExample e1 = new ShallowCloneExample();
//        System.out.println(""+e1.get(2));
//        ShallowCloneExample e2 = null;
//        try {
//            e2 = e1.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        e1.set(2,222);
//        System.out.println(""+e2.get(2));
//
//        DeepCloneExample de1 = new DeepCloneExample();
//        DeepCloneExample de2 = null;
//        try {
//            de2 = de1.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        de1.set(2, 222);
//        System.out.println(""+de2.get(2)); // 2
        List<Code> list = new ArrayList();
        Code code3 = new Code(3);
        Code code10 = new Code(10);
        list.add(new Code(1));
        list.add(new Code(2));
        list.add(code3);
        list.add(code3);
        list.add(new Code(9));
        list.add(code10);
        list.add(code10);
        list.add(new Code(11));
        for (Code i:list) {
            System.out.print(i.toString()+" ");
        }
        System.out.println("-------原始list--------");
        Set<Code> set = new TreeSet<>(list);
        for (Code i:set) {
            System.out.print(i.toString()+" ");
        }
        System.out.println("-------放入TreeSet中去重--------");

        Set<Code> set1 = new HashSet<>(list);
        for (Code i:set1) {
            System.out.print(i.toString()+" ");
        }
        System.out.println("-------放入HashSet中去重--------");

        list.clear();
        list.addAll(set);
        set.clear();
        set = null;
        for (Code i:list) {
            System.out.print(i.toString()+" ");
        }
        System.out.println("-------放入TreeSet中去重转换为list--------");

        list.clear();
        list.addAll(set1);
        set1.clear();
        set1 = null;
        for (Code i:list) {
            System.out.print(i.toString()+" ");
        }
        System.out.println("-------放入HashSet中去重转换为list--------");
    }
}
