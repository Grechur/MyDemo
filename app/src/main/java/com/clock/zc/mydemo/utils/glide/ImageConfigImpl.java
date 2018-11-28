package com.clock.zc.mydemo.utils.glide;

import android.widget.ImageView;

import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

public class ImageConfigImpl extends ImageConfig{
    private boolean hasCache;//是否需要缓存
    private BitmapTransformation transformation;//需要的图形

    //建造者模式来构建配置信息这个对象
    private ImageConfigImpl(Builder builder) {
        this.url = builder.url;
        this.imgView = builder.imageView;
        this.placeHolder = builder.placeHolder;
        this.hasCache = builder.hasCache;
        this.transformation = builder.transformation;
    }

    public boolean isHasCache() {
        return hasCache;
    }

    public BitmapTransformation getTransformation() {
        return transformation;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String url;
        private ImageView imageView;
        private int placeHolder;
        private boolean hasCache = true;//是否需要缓存
        private BitmapTransformation transformation;//需要的图形

        private Builder() {
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder placeholder(int placeholder) {
            this.placeHolder = placeholder;
            return this;
        }

        public Builder imageView(ImageView imageView) {
            this.imageView = imageView;
            return this;
        }

        public Builder transformation(BitmapTransformation transformation){
            this.transformation = transformation;
            return this;
        }

        public Builder hasCache(boolean hasCache){
            this.hasCache = hasCache;
            return this;
        }

        //构造出ImageConfigImpl对象
        public ImageConfigImpl build() {
            return new ImageConfigImpl(this);
        }
    }
}
