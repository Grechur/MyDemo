package com.clock.zc.mydemo.http.upload;

/**
 * Created by zz on 2018/5/14.
 */

public interface UploadProgressListener {
    void updateProgress(long totle,long progress);
}
