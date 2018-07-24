package com.clock.zc.mydemo.base;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.clock.zc.mydemo.ui.MyIntentService;
import com.clock.zc.mydemo.ui.ProxyActivity;
import com.clock.zc.mydemo.utils.proxyact.HookUtil;
//import com.qihoo360.replugin.RePluginApplication;
import com.squareup.leakcanary.LeakCanary;

import java.lang.reflect.Method;


/**
 * Created by Zc on 2017/8/28.
 */

public class DemoApplication extends Application {
    public static Context AppContext;
    private AssetManager assetManager;
    private Resources newResource;
    private Resources.Theme mTheme;
    @Override
    public void onCreate() {
        super.onCreate();

        LeakCanary.install(this);


    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        AppContext = base;
        MultiDex.install(this);
        try {
            //创建我们自己的Resource
            String apkPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/chajian_demo.apk";
            String mPath = getPackageResourcePath();

            assetManager = AssetManager.class.newInstance();
            Method addAssetPathMethod = assetManager.getClass().getDeclaredMethod("addAssetPath", String.class);
            addAssetPathMethod.setAccessible(true);

//            addAssetPathMethod.invoke(assetManager, mPath);
            addAssetPathMethod.invoke(assetManager, apkPath);


            Method ensureStringBlocks = AssetManager.class.getDeclaredMethod("ensureStringBlocks");
            ensureStringBlocks.setAccessible(true);
            ensureStringBlocks.invoke(assetManager);

            Resources supResource = getResources();
            Log.e("Main", "supResource = " + supResource);
            newResource = new Resources(assetManager, supResource.getDisplayMetrics(), supResource.getConfiguration());
            Log.e("Main", "设置 getResource = " + getResources());

            mTheme = newResource.newTheme();
            mTheme.setTo(super.getTheme());
        } catch (Exception e) {
            Log.e("Main", "走了我的callActivityOnCreate 错了 = " + e.getMessage());
            e.printStackTrace();
        }
    }
    @Override
    public AssetManager getAssets() {
        return assetManager == null ? super.getAssets() : assetManager;
    }

    @Override
    public Resources getResources() {
        return newResource == null ? super.getResources() : newResource;
    }

    @Override
    public Resources.Theme getTheme() {
        return mTheme == null ? super.getTheme() : mTheme;
    }
    public static Context getContext() {
        return AppContext;
    }
}
