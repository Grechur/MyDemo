package com.clock.zc.mydemo.http;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Zc on 2017/12/4.
 */

public class DataType {
    /*返回数据为String*/
    public static final int STRING = 1;

    /*返回数据为json对象*/
    public static final int JSON_OBJECT = 2;
    /*返回数据为json数组*/
    public static final int JSON_ARRAY = 3;

    /**
     * 自定义一个播放器状态注解
     */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({STRING, JSON_OBJECT, JSON_ARRAY})
    public @interface Type {
    }
}
