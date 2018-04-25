package com.clock.zc.mydemo.utils;

/**
 * Created by Zc on 2017/10/23.
 */

public class ColorUitl {
    public static int getColorWithAlpha(float alpha, int baseColor) {
        int a = Math.min(255, Math.max(0, (int) (alpha * 255))) << 24;
        int rgb = 0x00ffffff & baseColor;
        return a + rgb;
    }
}
