package com.clock.zc.mydemo.http;

import android.support.annotation.NonNull;
import android.text.TextUtils;


import com.clock.zc.mydemo.utils.NetworkUtils;
import com.clock.zc.mydemo.utils.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zc on 2017/12/4.
 */

public class HttpClient {


    /*用户设置的BASE_URL*/
    private static String BASE_URL = "";
    /*本地使用的baseUrl*/
    private String baseUrl = "";
    private static OkHttpClient okHttpClient;
    private Builder mBuilder;
    private Retrofit retrofit;
    private Observable<ResponseBody> mCall;
    private static final Map<String, Observable> CALL_MAP = new HashMap<>();

    /**
     * 获取HttpClient的单例
     *
     * @return HttpClient的唯一对象
     */
    private static HttpClient getIns() {
        return HttpClientHolder.sInstance;
    }

    /**
     * 单例模式中的静态内部类写法
     */
    private static class HttpClientHolder {
        private static final HttpClient sInstance = new HttpClient();
    }

    private HttpClient() {
        //HttpsUtil.SSLParams sslParams = HttpsUtil.getSslSocketFactory(Utils.getContext(), R.raw.cer,STORE_PASS , STORE_ALIAS);
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                //.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                // .hostnameVerifier(HttpsUtil.getHostnameVerifier())
                .addInterceptor(new LoggerInterceptor(null, true))
                .build();
    }

    public Builder getBuilder() {
        return mBuilder;
    }

    private void setBuilder(Builder builder) {
        this.mBuilder = builder;
    }

    /**
     * 获取的Retrofit的实例，
     * 引起Retrofit变化的因素只有静态变量BASE_URL的改变。
     */
    private void getRetrofit() {
        if (!BASE_URL.equals(baseUrl) || retrofit == null) {
            baseUrl = BASE_URL;
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.newThread()))
                    .build();
        }
    }

    public void post(BaseObserver baseObserver) {
        Builder builder = mBuilder;
        mCall = retrofit.create(ApiService.class)
                .executePost(builder.url, builder.params);
        putCall(builder, mCall);
        request(builder,baseObserver);
    }


    public void get(BaseObserver baseObserver) {
        Builder builder = mBuilder;
        if (!builder.params.isEmpty()) {
            String value = "";
            for (Map.Entry<String, String> entry : builder.params.entrySet()) {
                String mapKey = entry.getKey();
                String mapValue = entry.getValue();
                String span = value.equals("") ? "" : "&";
                String part = StringUtils.buffer(span, mapKey, "=", mapValue);
                value = StringUtils.buffer(value, part);
            }
            builder.url(StringUtils.buffer(builder.url, "?", value));
        }
        mCall = retrofit.create(ApiService.class).executeGet(builder.url);
        putCall(builder, mCall);
        request(builder,baseObserver);
    }


    private void request(final Builder builder,BaseObserver baseObserver) {
        if (!NetworkUtils.isConnected()) {
//            ToastUtils.showLongToastSafe(R.string.current_internet_invalid);
            baseObserver.onHandleError(-100,"网络连接失败");
            return;
        }
        mCall.observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(baseObserver);

    }


    /**
     * 添加某个请求
     */
    private synchronized void putCall(Builder builder, Observable call) {
        if (builder.tag == null)
            return;
        synchronized (CALL_MAP) {
            CALL_MAP.put(builder.tag.toString() + builder.url, call);
        }
    }


    /**
     * 取消某个界面都所有请求，或者是取消某个tag的所有请求;
     * 如果要取消某个tag单独请求，tag需要传入tag+url
     *
     * @param tag 请求标签
     */
    public synchronized void cancel(Object tag) {
        if (tag == null)
            return;
        List<String> list = new ArrayList<>();
        synchronized (CALL_MAP) {
            for (String key : CALL_MAP.keySet()) {
                if (key.startsWith(tag.toString())) {
                    CALL_MAP.get(key).unsubscribeOn(Schedulers.io());
                    list.add(key);
                }
            }
        }
        for (String s : list) {
            removeCall(s);
        }

    }

    /**
     * 移除某个请求
     *
     * @param url 添加的url
     */
    private synchronized void removeCall(String url) {
        synchronized (CALL_MAP) {
            for (String key : CALL_MAP.keySet()) {
                if (key.contains(url)) {
                    url = key;
                    break;
                }
            }
            CALL_MAP.remove(url);
        }
    }

    /**
     * Build a new HttpClient.
     * url is required before calling. All other methods are optional.
     */
    public static final class Builder {
        private String builderBaseUrl = "";
        private String url;
        private Object tag;
        private Map<String, String> params = new HashMap<>();
        /*返回数据的类型,默认是string类型*/
        @DataType.Type
        private int bodyType = DataType.STRING;
        /*解析类*/
        private Class clazz;

        public Builder() {
        }

        /**
         * 请求地址的baseUrl，最后会被赋值给HttpClient的静态变量BASE_URL；
         *
         * @param baseUrl 请求地址的baseUrl
         */
        public Builder baseUrl(String baseUrl) {
            this.builderBaseUrl = baseUrl;
            return this;
        }

        /**
         * 除baseUrl以外的部分，
         * 例如："mobile/login"
         *
         * @param url path路径
         */
        public Builder url(String url) {
            this.url = url;
            return this;
        }

        /**
         * 给当前网络请求添加标签，用于取消这个网络请求
         *
         * @param tag 标签
         */
        public Builder tag(Object tag) {
            this.tag = tag;
            return this;
        }

        /**
         * 添加请求参数
         *
         * @param key   键
         * @param value 值
         */
        public Builder params(String key, String value) {
            this.params.put(key, value);
            return this;
        }

        /**
         * 响应体类型设置,如果要响应体类型为STRING，请不要使用这个方法
         *
         * @param bodyType 响应体类型，分别:STRING，JSON_OBJECT,JSON_ARRAY,XML
         * @param clazz    指定的解析类
         * @param <T>      解析类
         */
        public <T> Builder bodyType(@DataType.Type int bodyType, @NonNull Class<T> clazz) {
            this.bodyType = bodyType;
            this.clazz = clazz;
            return this;
        }

        public HttpClient build() {
            if (!TextUtils.isEmpty(builderBaseUrl)) {
                BASE_URL = builderBaseUrl;
            }
            HttpClient client = HttpClient.getIns();
            client.getRetrofit();
            client.setBuilder(this);
            return client;
        }
    }

    /**
     * 数据解析方法
     *
     * @param data             要解析的数据
     * @param clazz            解析类
     * @param bodyType         解析数据类型
     * @param onResultListener 回调方数据接口

    @SuppressWarnings("unchecked")
    private void parseData(String data, Class clazz, @DataType.Type int bodyType, OnResultListener onResultListener) {
        switch (bodyType) {
            case DataType.STRING:
                onResultListener.onSuccess(data);
                break;
            case DataType.JSON_OBJECT:
                onResultListener.onSuccess(DataParseUtil.parseObject(data, clazz));
                break;
            case DataType.JSON_ARRAY:
                onResultListener.onSuccess(DataParseUtil.parseToArrayList(data, clazz));
                break;
            default:
                Logger.e("http parse tip:", "if you want return object, please use bodyType() set data type");
                break;
        }
    }
     */
}
