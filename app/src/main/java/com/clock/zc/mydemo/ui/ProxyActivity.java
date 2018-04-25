package com.clock.zc.mydemo.ui;

import android.annotation.TargetApi;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.clock.zc.mydemo.R;
import com.clock.zc.mydemo.utils.proxy.ClipHelper;

import java.lang.reflect.Method;

public class ProxyActivity extends AppCompatActivity {
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private AssetManager createAssetManager(String pFilePath) {
        try {
            final AssetManager assetManager = AssetManager.class.newInstance();
            final Class<?> assetManagerClazz = Class.forName("android.content.res.AssetManager");
            final Method addAssetPathMethod = assetManagerClazz.getDeclaredMethod("addAssetPath", String.class);
            addAssetPathMethod.setAccessible(true);
            addAssetPathMethod.invoke(assetManager, pFilePath);
            return assetManager;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private Resources createResources(String pFilePath){
        final AssetManager assetManager = createAssetManager(pFilePath);
        Resources superRes = this.getResources();
        return new Resources(assetManager, superRes.getDisplayMetrics(), superRes.getConfiguration());
    }
}
