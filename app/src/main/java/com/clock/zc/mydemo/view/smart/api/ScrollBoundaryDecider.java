package com.clock.zc.mydemo.view.smart.api;

import android.view.View;

public interface ScrollBoundaryDecider {
    boolean canRefresh(View var1);

    boolean canLoadmore(View var1);
}
