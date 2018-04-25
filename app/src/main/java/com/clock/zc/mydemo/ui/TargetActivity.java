package com.clock.zc.mydemo.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.clock.zc.mydemo.R;

import java.lang.reflect.Method;

public class TargetActivity extends AppCompatActivity {
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


}
