package com.grechur.testhook;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("Main","test this = " + this);
        Log.e("Main","getResource = " + getResources());
        Log.e("Main","getApplication = " + getApplication());
        Log.e("Main","getApplication class = " + getApplication().getClass().getName());
        setContentView(R.layout.activity_main2);
//        TextView textView = new TextView(this);
//        textView.setText("欢迎进入插件");
//        setContentView(textView);
    }
    @Override
    public Resources getResources() {
        Log.e("Main","getApplicationContext = " + getApplicationContext());
        Log.e("Main","getApplicationContext 2 = " + getApplication());
        Log.e("Main","getApplicationContext 2 = " + super.getResources());
//        Log.e("Main","getApplicationContext 3= " + getApplication().getResources());
        if(getApplication() != null && getApplication().getResources() != null){
            return getApplication().getResources();
        }
        return super.getResources();
    }

    @Override
    public AssetManager getAssets() {
        if(getApplication() != null && getApplication().getAssets() != null){
            return getApplication().getAssets();
        }
        return super.getAssets();
    }

    @Override
    public Resources.Theme getTheme() {
        if(getApplication() != null && getApplication().getTheme() != null){
            return getApplication().getTheme();
        }
        return super.getTheme();
    }
}
