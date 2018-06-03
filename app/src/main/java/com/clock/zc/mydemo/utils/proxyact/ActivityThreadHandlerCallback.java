package com.clock.zc.mydemo.utils.proxyact;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;


import java.lang.reflect.Field;

/**
 * Created by Zc on 2018/4/10.
 */

public class ActivityThreadHandlerCallback implements Handler.Callback{
    public static final String TAG ="ActivityThreadHandlerCallback";
    private Handler handler;
    public ActivityThreadHandlerCallback(Handler handler) {
        this.handler = handler;
    }
    @SuppressLint("LongLogTag")
    @Override
    public boolean handleMessage(Message msg) {
        Log.e(TAG, "handleMessage");
        Log.e(TAG, "what:"+msg.what);
        //替换之前的Intent
        if (msg.what ==100) {
            Log.i("HookAmsUtil","lauchActivity");
            handleLauchActivity(msg);
        }

        handler.handleMessage(msg);
        return true;
    }



    private void handleLauchActivity(Message msg) {
        Object obj = msg.obj;//ActivityClientRecord
        try{
            Field intentField = obj.getClass().getDeclaredField("intent");
            intentField.setAccessible(true);
            Intent proxyInent = (Intent) intentField.get(obj);
            Intent realIntent = proxyInent.getParcelableExtra("oldIntent");
            if (realIntent != null) {
                proxyInent.setComponent(realIntent.getComponent());
            }
        }catch (Exception e){
            Log.i("HookAmsUtil","lauchActivity falied");
        }

    }
}


