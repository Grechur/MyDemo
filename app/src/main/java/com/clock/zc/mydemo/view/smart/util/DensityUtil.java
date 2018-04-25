package com.clock.zc.mydemo.view.smart.util;

import android.content.Context;
import android.content.res.Resources;

public class DensityUtil {
    float density;

    public DensityUtil() {
        this.density = Resources.getSystem().getDisplayMetrics().density;
    }

    public static int dp2px(float dpValue) {
        return (int)(0.5F + dpValue * Resources.getSystem().getDisplayMetrics().density);
    }

    public static float px2dp(float pxValue) {
        return pxValue / Resources.getSystem().getDisplayMetrics().density;
    }

    public int dip2px(float dpValue) {
        return (int)(0.5F + dpValue * this.density);
    }

    public float px2dip(float pxValue) {
        return pxValue / this.density;
    }


    public static float dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }
}
