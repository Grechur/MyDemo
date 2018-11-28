package com.clock.zc.mydemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.clock.zc.mydemo.R;
import com.clock.zc.mydemo.base.BaseActivity;


public class PresentActivity extends BaseActivity {
    public static final String girl = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/screenshot/girl.jpg";
    public static final String girl_thumbnail = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/screenshot/girl_thumbnail.jpg";
    public static final String cat = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/screenshot/cat.jpg";
    public static final String cat_thumbnail = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/screenshot/cat_thumbnail.jpg";
    private static final String TAG ="PresentActivity" ;

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present);
        imageView = findViewById(R.id.image_view);
    }

    public void loadImage(View view) {
        String url = "http://www.zhlzw.com/UploadFiles/Article_UploadFiles/201204/20120412123914329.jpg";

        Glide.with(this)
                .load(url)
                .thumbnail(0.6f)
                .into(imageView);

    }
}
