package com.clock.zc.mydemo.base;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.clock.zc.mydemo.ui.MyIntentService;
import com.clock.zc.mydemo.ui.ProxyActivity;
import com.clock.zc.mydemo.utils.proxyact.HookUtil;
import com.qihoo360.replugin.RePluginApplication;
import com.squareup.leakcanary.LeakCanary;


/**
 * Created by Zc on 2017/8/28.
 */

public class DemoApplication extends RePluginApplication {
    public static Context AppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        AppContext = getApplicationContext();
        LeakCanary.install(this);
        HookUtil hookAmsUtil = new HookUtil(this);
        hookAmsUtil.hookSystemHandler();
        hookAmsUtil.hookAms();

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
