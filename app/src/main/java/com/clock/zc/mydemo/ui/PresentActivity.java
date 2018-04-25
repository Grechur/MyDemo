package com.clock.zc.mydemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.clock.zc.mydemo.R;
import com.clock.zc.mydemo.base.BaseActivity;
import com.sunfusheng.glideimageview.GlideImageLoader;
import com.sunfusheng.glideimageview.GlideImageView;
import com.sunfusheng.glideimageview.progress.CircleProgressView;
import com.sunfusheng.glideimageview.progress.OnGlideImageViewListener;

public class PresentActivity extends BaseActivity {
    public static final String girl = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/screenshot/girl.jpg";
    public static final String girl_thumbnail = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/screenshot/girl_thumbnail.jpg";
    public static final String cat = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/screenshot/cat.jpg";
    public static final String cat_thumbnail = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/screenshot/cat_thumbnail.jpg";
    private static final String TAG ="PresentActivity" ;
    GlideImageView glideImageView;
    CircleProgressView circleProgressView;
    GlideImageView image41;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present);
        glideImageView = (GlideImageView) findViewById(R.id.image23);
        circleProgressView = (CircleProgressView) findViewById(R.id.progressView1);
        image41 = (GlideImageView) findViewById(R.id.image41);
    }

    public void loadImage(View view) {
        String url = "http://www.zhlzw.com/UploadFiles/Article_UploadFiles/201204/20120412123914329.jpg";http://p1.pstatp.com/large/166200019850062839d3

//        Glide.with(this)
//                .load(url)
//                .transition(DrawableTransitionOptions.withCrossFade())
//                .thumbnail(0.6f)
//                .into(imageView);
        glideImageView.loadImage(url,R.mipmap.ic_launcher);
        // 第二种方式加载：可以解锁更多功能
        RequestOptions requestOptions = image41.requestOptions(R.color.black)
                .centerCrop();
        RequestOptions requestOptionsWithoutCache = image41.requestOptions(R.color.black)
                .centerCrop()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE);
        // 第一种方式加载
        GlideImageLoader imageLoader = image41.getImageLoader();

        imageLoader.setOnGlideImageViewListener(cat, new OnGlideImageViewListener() {
            @Override
            public void onProgress(int percent, boolean isDone, GlideException exception) {
                if (exception != null && !TextUtils.isEmpty(exception.getMessage())) {
                    Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
                }
                Toast.makeText(getApplicationContext(), percent+"", Toast.LENGTH_LONG).show();
                circleProgressView.setProgress(percent);
                circleProgressView.setVisibility(isDone ? View.GONE : View.VISIBLE);
            }
        });

        imageLoader.requestBuilder(cat, requestOptionsWithoutCache)
                .thumbnail(Glide.with(this)
                        .load(cat_thumbnail)
                        .apply(requestOptions))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(image41);
    }
}
