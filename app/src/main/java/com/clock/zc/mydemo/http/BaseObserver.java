package com.clock.zc.mydemo.http;


import com.clock.zc.mydemo.base.BaseData;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Zc on 2017/12/20.
 */

public abstract class BaseObserver<T> implements Observer<BaseData<T>> {
    //mDisposable.dispose();开光，用来切断连接
    private Disposable mDisposable;
    private final int SUCCESS_CODE = 200;
    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
    }

    @Override
    public void onNext(BaseData<T> value) {
        if (value.getCode() == SUCCESS_CODE) {
            T t = value.getData();
            onHandleSuccess(t);
        } else {
            onHandleError(value.getCode(), value.getErr_msg());
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }

    public abstract void onHandleSuccess(T t);

    void onHandleError(int code, String message) {
    }
}
