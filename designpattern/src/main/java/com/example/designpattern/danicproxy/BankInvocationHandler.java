package com.example.designpattern.danicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zz on 2018/5/11.
 */

public class BankInvocationHandler implements InvocationHandler{
    private Object mObject;

    public BankInvocationHandler(Object object){
        this.mObject = object;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("method:"+method.getName());
        System.out.println("开始受理");
        Object obj = method.invoke(mObject,objects);
        System.out.println("受理完毕");
        return obj;
    }
}
