package com.clock.zc.mydemo.utils.glide;

import android.content.Context;

public class ImageLoader<T extends ImageConfig> {
    private IBaseImageLoaderStrategy mStrategy;

    private static ImageLoader mImageLoader;
    private ImageLoader(Class clazz){
        try {
            mStrategy = (IBaseImageLoaderStrategy) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public static final ImageLoader getInstance(Class clazz) {
        if(mImageLoader == null){
            synchronized (ImageLoader.class){
                if(mImageLoader == null){
                    mImageLoader = new ImageLoader(clazz);
                }
            }
        }
        return mImageLoader;
    }

    public void LoadImage(Context context,T config){
        if(this.mStrategy==null){
            throw new
                    NullPointerException("you should invoke setLoadImgStrategy first");
        }
        this.mStrategy.displayImage(context,config);

    }
}
