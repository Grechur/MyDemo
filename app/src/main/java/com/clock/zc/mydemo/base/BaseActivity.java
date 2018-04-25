package com.clock.zc.mydemo.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.clock.zc.mydemo.R;
import com.clock.zc.mydemo.view.StatusBarCompat;
import com.clock.zc.mydemo.view.TransitionHelper;
import com.litesuits.orm.LiteOrm;

import java.util.Collections;

//import com.clock.zc.punchtheclock.bean.ClockHistory;
//import com.clock.zc.punchtheclock.util.DBManager;

//import org.xutils.x;

public class BaseActivity extends AppCompatActivity {
    protected DemoApplication application;
    protected Context context;
    protected static LiteOrm liteOrm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarCompat.compat(this, getResources().getColor(R.color.background));
        setupWindowAnimations();
        context = this;
        application = (DemoApplication) getApplication();
        if (liteOrm == null) {
            liteOrm = LiteOrm.newSingleInstance(this, "liteorm.db");
        }
        liteOrm.setDebugged(true); // open the log
        
    }

    protected int dip2px(Context context,float dipValue)
    {
        Resources r = context.getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dipValue, r.getDisplayMetrics());
    }
    protected void toastCenter(String text) {
        try {
            Toast t = Toast.makeText(this, text,
                    Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER, 0, 0);
            View v = View.inflate(context, R.layout.toast_layout,null);
            TextView textView = (TextView) v.findViewById(R.id.tv_message);
            textView.setText(text);
            t.setView(v);
            t.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void toast(String text) {
        try {
            Toast t = Toast.makeText(this, text,
                    Toast.LENGTH_SHORT);

            View v = View.inflate(context,R.layout.toast_layout,null);
            TextView textView = (TextView) v.findViewById(R.id.tv_message);
            textView.setText(text);
            t.setView(v);
            t.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void setupWindowAnimations() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide enterslideTransition =  new Slide();
            enterslideTransition.setSlideEdge(Gravity.RIGHT);
            enterslideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
            enterslideTransition.excludeTarget(android.R.id.statusBarBackground,true);
            getWindow().setEnterTransition(enterslideTransition);

            Slide slideTransition =  new Slide();
            slideTransition.setSlideEdge(Gravity.LEFT);
            slideTransition.excludeTarget(android.R.id.statusBarBackground,true);
            slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
            getWindow().setReenterTransition(slideTransition);
            getWindow().setExitTransition(slideTransition);
        }

    }
    protected void startAct(Class target) {
        Intent i = new Intent();
        startAct(target,i);
    }
    protected void startAct(Class target,Intent i) {
        i.setClass(context, target);
        Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants((Activity) context, true);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, pairs);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            startActivity(i, transitionActivityOptions.toBundle());
        }else{
            startActivity(i);
        }
    }
}
