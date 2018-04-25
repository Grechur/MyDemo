package com.clock.zc.mydemo.utils.proxyact;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Zc on 2018/4/24.
 */

public class PackageManagerHandler  implements InvocationHandler {
    public static final String TAG = "PackageManagerHandler";
    private Object iPackageManager;
    private Context mContext;
    private Class<? extends Activity> proxyActivity;
    public PackageManagerHandler(Object iPackageManager, Context context, Class<? extends Activity> proxyActivity){
        this.iPackageManager = iPackageManager;
        this.mContext = context;
        this.proxyActivity = proxyActivity;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.e(TAG,"进入拦截package:"+method.getName());
        if("getActivityInfo".equals(method.getName())){
            ComponentName proComponentName = new ComponentName(mContext, proxyActivity);
            args[0] = proComponentName;
        }
        return method.invoke(iPackageManager,args);
    }
}