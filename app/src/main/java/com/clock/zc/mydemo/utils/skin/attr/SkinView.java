package com.clock.zc.mydemo.utils.skin.attr;

import android.view.View;

import java.util.List;

/**
 * Created by Zc on 2018/4/26.
 */

public class SkinView {
    private View mView;

    private List<SkinAttr> mAttrs;
    
    public void skin(){
        for (SkinAttr mAttr : mAttrs) {
            mAttr.skin(mView);
        }
    }
}
