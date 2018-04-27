package com.clock.zc.mydemo.utils.skin.attr;

import android.view.View;

/**
 * Created by Zc on 2018/4/26.
 */

public enum  SkinType {
    TEXT_COLOR("text_color") {
        @Override
        public void skin(View view, String resName) {

        }
    },BACKGROUND("background") {
        @Override
        public void skin(View view, String resName) {

        }
    },SRC("src") {
        @Override
        public void skin(View view, String resName) {

        }
    };
    private String mResName;
    SkinType(String resName){
        this.mResName = resName;
    }

    public abstract void skin(View view,String resName);
}
