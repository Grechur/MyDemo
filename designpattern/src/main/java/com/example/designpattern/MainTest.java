package com.example.designpattern;

import com.example.designpattern.builder.HotDryNoodlesWithBuilder;
import com.example.designpattern.factory.Cusins;
import com.example.designpattern.factory.OrangeJuice;
import com.example.designpattern.factory.OrangeJuiceMachine;
import com.example.designpattern.proxy.DaLong;
import com.example.designpattern.proxy.XiaoGuang;
import com.example.designpattern.simplefactory.CousinsFactory;
import com.example.designpattern.simplefactory.Drink;
import com.example.designpattern.single.Cousins;
import com.example.designpattern.single.Form;
import com.example.designpattern.single.XiaoZhang;
import com.example.designpattern.strategy.Checkstand;
import com.example.designpattern.stuff.Coke;
import com.example.designpattern.stuff.Ice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainTest {
    public static void main(String[] args) {
//        HotDryNoodlesWithBuilder noodlesWithBuilder1 = new HotDryNoodlesWithBuilder.Builder()
//                .withChili()
//                .withParsley()
//                .builder();
//        System.out.println("顾客1"+noodlesWithBuilder1.toString());
//        HotDryNoodlesWithBuilder noodlesWithBuilder2 = new HotDryNoodlesWithBuilder.Builder()
//                .withSauerkraut()
//                .withParsley()
//                .builder();
//        System.out.println("顾客2"+noodlesWithBuilder2.toString());
//
//        Drink drink = CousinsFactory.create("");
//        drink.make();
//
//        Cusins cusins = new Cusins();
//        cusins.setBeverageMachine(new OrangeJuiceMachine());
//        com.example.designpattern.factory.Drink drink1 = cusins.takeDrink();
//        System.out.println("args = [" + args + "]"+drink1.toString());
//        ;
//        // 收银台, 默认
//        Checkstand checkstand = new Checkstand();
//        checkstand.printBill();
//
//        com.example.designpattern.stuff.Drink drink2 = new Ice(new Coke());
//        System.out.println(drink2.make());
//
//        DaLong daLong = new DaLong(new XiaoGuang());
//        // 第一轮, 对方报价120.
//         daLong.signing(120);
//        // 第二轮, 对方报价100.
//         daLong.signing(100);
//        // 第三轮, 对方报价90.
//        daLong.signing(90);
//
//
//        Cousins cousins = new Cousins();
//        Form form = cousins.submitReport();
//        System.out.println(form);
//        XiaoZhang xiaoZhang = new XiaoZhang();
//        Form form2 = xiaoZhang.submitReport();
//        System.out.println(form2);
        Coke coke = new Coke();
//
//        Coke coke1 = new Coke();
//        System.out.println("使用==:"+(coke == coke1));
//        System.out.println("使用equals:"+coke.equals(coke1));
//        System.out.println("coke的hash值:"+coke.hashCode()+"coke1的hash值:"+coke1.hashCode());
//
//        Coke coke2 = coke;
//        System.out.println("使用==:"+(coke == coke2));
//        System.out.println("使用equals:"+coke.equals(coke2));
//        System.out.println("coke的hash值:"+coke.hashCode()+"coke2的hash值:"+coke2.hashCode());
//        Stack stack = new Stack();
//        stack.push("a");
//        stack.push(1);
//        stack.push(coke);
//        int size = stack.size();
//        for (int i=0;i<size;i++){
//            System.out.println("这是第"+i+"个"+stack.pop());
//
//        }
//        int[] numbers = {1,2,3,5,7,9,10,11};
//        List<Stack<Integer>> list = new ArrayList<>();
//        Stack<Integer> q = new Stack<>();
//        list.add(q);
//        for (int n:numbers) {
//            if(q.size()==0){
//                q.push(n);
//            }else{
//                if(n-1 != list.get(list.size()-1).peek()){
//                    Stack<Integer> q1 = new Stack();
//                    q1.push(n);
//                    list.add(q1);
//                }else{
//                    list.get(list.size()-1).push(n);
//                }
//            }
//        }
//        for (Stack<Integer> s:list) {
//            System.out.println("-----------------");
//            for (Integer i:s){
//                System.out.print(" "+i);
//            }
//        }

    }
}
