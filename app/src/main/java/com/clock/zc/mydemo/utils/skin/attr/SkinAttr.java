package com.clock.zc.mydemo.utils.skin.attr;

import android.view.View;

/**
 * Created by Zc on 2018/4/26.
 */

public class SkinAttr {
    private String mResName;
    private SkinType mType;

    public void skin(View view) {
        mType.skin(view,mResName);
    }
}
