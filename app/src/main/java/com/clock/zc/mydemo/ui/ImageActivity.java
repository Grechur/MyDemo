package com.clock.zc.mydemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.clock.zc.mydemo.R;
import com.clock.zc.mydemo.utils.glide.GlideCircleTransform;
import com.clock.zc.mydemo.utils.glide.GlideImageLoaderStrategy;
import com.clock.zc.mydemo.utils.glide.ImageConfigImpl;
import com.clock.zc.mydemo.utils.glide.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageActivity extends AppCompatActivity {

//    @BindView(R.id.iv_imag)
    ImageView imageView;
    public String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1543402134399&di=6ed3ee762ca09e87d85bc95f222306ba&imgtype=0&src=http%3A%2F%2Fowrosclbg.bkt.clouddn.com%2F4eaa862d0e93fd28d98aa1b4c7609535.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
//        ButterKnife.bind(this);
        imageView = findViewById(R.id.iv_imag);
//        ImageLoader.getInstance(GlideImageLoaderStrategy.class).LoadImage(this,
//                ImageConfigImpl.builder()
//                        .url(url)
//                        .hasCache(true)
//                        .transformation(new GlideCircleTransform(this))
//                        .placeholder(0)
//                        .imageView(imageView)
//                        .build()
//
//        );
        Glide.with(this).load(url).into(imageView);
    }
}
