package com.example.designpattern.fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Zc on 2018/3/15.
 */

public class TestFanshe {
    public static void main(String[] args) throws Exception {
        //必须是完整的路径
        Class clazz = Class.forName("com.example.designpattern.fanshe.Student");

        //获取所有的构造函数
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c: constructors) {
            System.out.println(c);
        }

        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        constructors = clazz.getDeclaredConstructors();
        for (Constructor c:constructors) {
            System.out.println(c);
        }

        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor pConstructor = clazz.getConstructor();
        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        //2>、返回的是描述这个无参构造函数的类对象。
        System.out.println(pConstructor);

        //调用构造方法
        Object object = pConstructor.newInstance();
        System.out.println(object);

        System.out.println("******************获取私有构造方法，并调用*******************************");
        Constructor con = clazz.getDeclaredConstructor(char.class);
        System.out.println(con);
        //调用构造方法
        con.setAccessible(true);//暴力访问(忽略掉访问修饰符)
        object = con.newInstance('男');
        System.out.println("******************获取私有方法，并调用*******************************");
        Method pMethod = clazz.getDeclaredMethod("add");
        System.out.println(pMethod);
        pMethod.setAccessible(true);//需要解除私有限定
        pMethod.invoke(object);
        System.out.println("******************获取公有方法，并调用*******************************");
        Method puMethod = clazz.getMethod("name");
        object = clazz.getConstructor().newInstance();
        Object result = puMethod.invoke(object);
        System.out.println(result);

        System.out.println("******************获取Student类的main方法，并调用*******************************");
        Method mainMethod = clazz.getMethod("main",String[].class);
        //第一个参数，对象类型，因为方法是static静态的，所以为null可以，第二个参数是String数组，这里要注意在jdk1.4时是数组，jdk1.5之后是可变参数
        mainMethod.invoke(null,(Object) new String[]{"a","b"});
    }
}
