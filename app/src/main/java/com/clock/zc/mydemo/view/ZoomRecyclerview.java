package com.clock.zc.mydemo.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;

import com.clock.zc.mydemo.R;
import com.clock.zc.mydemo.utils.ColorUitl;

import java.lang.ref.WeakReference;

/**
 * Created by Zc on 2017/10/20.
 */

public class ZoomRecyclerview extends RecyclerView {
    private View toolView;
    private float mPosition;
    private float mDiff;
    private int top = 0 ;
    static class ResetAnimation extends Animation {
        private WeakReference<ZoomRecyclerview> listviewRef;
        private ImageView mImageView;
        private int mCurrentHeight;
        private int mExtraHeight;

        public ResetAnimation(ZoomRecyclerview listView){
            listviewRef = new WeakReference<ZoomRecyclerview>(listView);
            if(listviewRef!=null){
                mCurrentHeight = listviewRef.get().mImageView.getHeight();
                mExtraHeight = mCurrentHeight - listviewRef.get().mMinHeaderHeight;
            }
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            if(listviewRef!=null){
                listviewRef.get().mImageView.getLayoutParams().height = (int) (mCurrentHeight - mExtraHeight * interpolatedTime);
                listviewRef.get().mImageView.requestLayout();
            }
            super.applyTransformation(interpolatedTime, t);
        }
    }

    private ImageView mImageView;
    private int mMinHeaderHeight;

    public ZoomRecyclerview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        /**
         * 拉伸过渡时，处理图片的缩放 ---处理图片高度
         * deltaY: y轴方向拉伸过度的偏移量
         *  - ：下拉过度
         *  + ：上拉过度
         */
        if(deltaY < 0 && mImageView.getHeight() < mMinHeaderHeight * 1.6){
            mImageView.getLayoutParams().height = mImageView.getHeight() - deltaY;
            mImageView.requestLayout();
        }else if(deltaY > 0 && mImageView.getHeight() > mMinHeaderHeight) {
            mImageView.getLayoutParams().height = mImageView.getHeight() - deltaY;
            mImageView.requestLayout();
        }
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        View headerView = (View) mImageView.getParent();
        top = headerView.getTop();
        if(top < 0 ){
//            mImageView.getLayoutParams().height = mImageView.getHeight() + top;
//            headerView.layout(headerView.getLeft(), 0, headerView.getRight(), headerView.getHeight());
//            mImageView.requestLayout();
            int h = headerView.getHeight();
            float tp = (float) Math.abs(top*1.5);
            int baseColor = getResources().getColor(R.color.background);
            float alpha = Math.min(1,  tp / h);
            toolView.setBackgroundColor(ColorUitl.getColorWithAlpha(alpha, baseColor));
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }

//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        super.onLayout(changed, l, t, r, b);
//
//    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        if(mMinHeaderHeight == 0) mMinHeaderHeight = mImageView.getHeight();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                ZoomRecyclerview.ResetAnimation animation = new ZoomRecyclerview.ResetAnimation(this);
                animation.setDuration(100);
                mImageView.startAnimation(animation);

                break;
            case MotionEvent.ACTION_DOWN:
                mPosition = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                mDiff = (float) ((ev.getY() - mPosition)/5);
                if(top == 0){
                    if(mDiff > 0 && mImageView.getHeight() < mMinHeaderHeight * 1.6){
                        mImageView.getLayoutParams().height = (int) (mImageView.getHeight() + mDiff);
                        mImageView.requestLayout();
                    }else if(mDiff < 0 && mImageView.getHeight() > mMinHeaderHeight) {
                        mImageView.getLayoutParams().height = (int) (mImageView.getHeight() + mDiff);
                        mImageView.requestLayout();
                    }
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    public void setImageView(ImageView imageView) {
        this.mImageView = imageView;
    }

    public void setToolView(View toolView) {
        this.toolView = toolView;
    }
}
