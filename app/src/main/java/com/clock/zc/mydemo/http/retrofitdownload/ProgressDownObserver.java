package com.clock.zc.mydemo.http.retrofitdownload;


import com.clock.zc.mydemo.http.retrofitdownload.DownLoadListener.DownloadProgressListener;
import com.clock.zc.mydemo.utils.DbDownUtil;

import java.lang.ref.SoftReference;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Zc on 2017/12/21.
 * Observer的调用顺序onSubscribe  onNext  onError或onComplete
 */

public class ProgressDownObserver<T> implements DownloadProgressListener, Observer<DownInfo> {
    //弱引用结果回调
    private SoftReference<HttpDownOnNextListener> mSubscriberOnNextListener;
    /*下载数据*/
    private DownInfo downInfo;
    private Disposable mDisposable;
    public ProgressDownObserver(DownInfo downInfo) {
        this.mSubscriberOnNextListener = new SoftReference<>(downInfo.getListener());
        this.downInfo=downInfo;
    }


    public void setDownInfo(DownInfo downInfo) {
        this.mSubscriberOnNextListener = new SoftReference<>(downInfo.getListener());
        this.downInfo=downInfo;
    }
    /**
     * 订阅开始时调用
     * 显示ProgressDialog
     */
    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
        if(mSubscriberOnNextListener.get()!=null){
            mSubscriberOnNextListener.get().onStart();
        }
        downInfo.setState(DownState.START);
    }

    @Override
    public void onNext(DownInfo downInfo) {
        if (mSubscriberOnNextListener.get() != null) {
            mSubscriberOnNextListener.get().onNext(downInfo);
        }
    }

    @Override
    public void onError(Throwable e) {
        if(mSubscriberOnNextListener.get()!=null){
            mSubscriberOnNextListener.get().onError(e);
        }
        DownLoadManager.getInstance().remove(downInfo);
        downInfo.setState(DownState.ERROR);
        DbDownUtil.getInstance().update(downInfo);
    }

    @Override
    public void onComplete() {
        if(mSubscriberOnNextListener.get()!=null){
            mSubscriberOnNextListener.get().onComplete();
        }
        DownLoadManager.getInstance().remove(downInfo);
        downInfo.setState(DownState.FINISH);
        DbDownUtil.getInstance().update(downInfo);
    }

    @Override
    public void update(long read, long count, boolean done) {
        if(downInfo.getCountLength()>count){
            read=downInfo.getCountLength()-count+read;
        }else{
            downInfo.setCountLength(count);
        }
        downInfo.setReadLength(read);
        if (mSubscriberOnNextListener.get() != null) {
            /*接受进度消息，造成UI阻塞，如果不需要显示进度可去掉实现逻辑，减少压力*/
            Observable.just(read).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Long>() {
                        @Override
                        public void accept(Long aLong) throws Exception {
                            if(downInfo.getState()==DownState.PAUSE||downInfo.getState()==DownState.STOP)return;
                            downInfo.setState(DownState.DOWN);
                            mSubscriberOnNextListener.get().updateProgress(aLong,downInfo.getCountLength());
                        }
                    });


        }
    }
    public Disposable getDisposable(){
        return mDisposable;
    }
}
