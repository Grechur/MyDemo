package com.clock.zc.mydemo.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.clock.zc.mydemo.R;

import static com.clock.zc.mydemo.ui.TestIntentService.EXTRA_IMG_PATH;


public class IntentServiceActivity extends AppCompatActivity {
    public static final String UPLOAD_RESULT = "com.zhy.blogcodes.intentservice.UPLOAD_RESULT";
    public static final String TAG = "IntentServiceActivity";

    private LinearLayout mLyTaskContainer;
    private ProgressBar progressBar;
    private TextView tv;
    MyHandle handle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);
        handle = new MyHandle();
        mLyTaskContainer = (LinearLayout) findViewById(R.id.id_ll_taskcontainer);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        tv = (TextView) findViewById(R.id.tv);
        Log.e(TAG,Thread.currentThread().getName()+"");
        progressBarChange();
        registerReceiver();
    }


    private BroadcastReceiver uploadImgReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            if (intent.getAction() == UPLOAD_RESULT)
            {
                String path = intent.getStringExtra(EXTRA_IMG_PATH);

                handleResult(path);

            }

        }
    };
    private void progressBarChange() {
        //开启一个线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG,Thread.currentThread().getName()+"");
                //得到progeressBar的最大长度
                int progressBarMax = progressBar.getMax();
                try {
                    //progressBar当前的长度没有达到他的最长度,让循环一直进行
                    while (progressBarMax != progressBar.getProgress()) {
                        //拿到一个每次前进的进度值,因为是要10s完成,所以分为10份
                        int stepProgress = progressBarMax / 10;
                        //progressBar当前的进度值
                        int currentProgress = progressBar.getProgress();
                        //让progressBar进度为每次前进最大值的十分之一
                        progressBar.setProgress(currentProgress + stepProgress);
                        Message message = new Message();
                        message.arg1 = currentProgress + stepProgress;
                        handle.sendMessage(message);
                        //前进一次,睡眠一秒
                        Thread.sleep(1000);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        //开启线程
        thread.start();
    }
    private void handleResult(String path)
    {
        TextView tv = (TextView) mLyTaskContainer.findViewWithTag(path);
        tv.setText(path + " upload success ~~~ ");
    }



    private void registerReceiver()
    {
        IntentFilter filter = new IntentFilter();
        filter.addAction(UPLOAD_RESULT);
        registerReceiver(uploadImgReceiver, filter);
    }

    int i = 0;

    public void addTask(View view)
    {
        //模拟路径
        String path = "/sdcard/imgs/" + (++i) + ".png";
        startUploadImg(this, path);

        TextView tv = new TextView(this);
        mLyTaskContainer.addView(tv);
        tv.setText(path + " is uploading ...");
        tv.setTag(path);
    }

    public static void startUploadImg(Context context, String path)
    {
        Intent intent = new Intent(context, TestIntentService.class);
        intent.setAction(TestIntentService.ACTION_UPLOAD_IMG);
        intent.putExtra(EXTRA_IMG_PATH, path);
        context.startService(intent);
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        unregisterReceiver(uploadImgReceiver);
    }
//    Handler handler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            int progress= msg.arg1;
//            Log.e(TAG,Thread.currentThread().getName());
//            tv.setText(progress+"");
//        }
//    };

    class MyHandle extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int progress= msg.arg1;
            Log.e(TAG,Thread.currentThread().getName());
            tv.setText(progress+"");
        }
    }
}
