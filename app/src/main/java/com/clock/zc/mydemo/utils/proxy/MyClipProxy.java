package com.clock.zc.mydemo.utils.proxy;

import android.os.IBinder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Zc on 2018/2/27.
 */

public class MyClipProxy implements InvocationHandler{
    private final IBinder mBase;
    public MyClipProxy(IBinder binder){
        mBase = binder;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //拦截原系统类查询本地是否有这个代理的方法
        if("queryLocalInterface".equals(method.getName())){
            //1.拿到系统的aidl类中的stub，因为这个对象本来就是个代理,而且源码执行了
            Class<?> mStiubClaass = Class.forName("android.content.IClipboard$Stub");
            //2.在拿到IClipboard本地对象类
            Class<?> mIClipboard = Class.forName("android.content.IClipboard");
            //3.创建我们自己的代理
            return Proxy.newProxyInstance(mStiubClaass.getClassLoader(),
                    new Class[]{mIClipboard},
                    new MyClip(mBase,mStiubClaass));
        }
        return method.invoke(mBase,args);
    }
}
