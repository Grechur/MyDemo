package com.clock.zc.mydemo.http.upload;

import java.io.IOException;


import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;

/**
 * Created by zz on 2018/5/14.
 */

public class UpMultipartBody extends RequestBody{
    //静态代理目标
    RequestBody mRequestBody;

    long mCurrentLength = 0;

    UploadProgressListener mListener;

    public UpMultipartBody(RequestBody requestBody){
        this.mRequestBody = requestBody;
    }

    public UpMultipartBody(RequestBody requestBody,UploadProgressListener listener){
        this.mRequestBody = requestBody;
        this.mListener = listener;
    }
    @Override
    public MediaType contentType() {
        return mRequestBody.contentType();
    }

    @Override
    public long contentLength() throws IOException {
        return mRequestBody.contentLength();
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {

        //总长度
        long contentLength = contentLength();

        //获取当前写入了多少数据



        ForwardingSink forwardingSink = new ForwardingSink(sink) {
            @Override
            public void write(Buffer source, long byteCount) throws IOException {
                mCurrentLength += byteCount;
                mListener.updateProgress(contentLength,mCurrentLength);
                super.write(source, byteCount);
            }
        };

        BufferedSink bufferedSink = Okio.buffer(forwardingSink);

        mRequestBody.writeTo(bufferedSink);

        bufferedSink.flush();
    }
}
