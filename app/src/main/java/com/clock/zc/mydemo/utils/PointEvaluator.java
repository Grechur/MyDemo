package com.clock.zc.mydemo.utils;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * Created by Zc on 2017/10/18.
 */

public class PointEvaluator implements TypeEvaluator<PointF> {
    @Override
    public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
        float x = startValue.x + fraction * (endValue.x - startValue.x);
        float y = startValue.y + fraction * (endValue.y - startValue.y);
        return new PointF(x, y);
    }
}
