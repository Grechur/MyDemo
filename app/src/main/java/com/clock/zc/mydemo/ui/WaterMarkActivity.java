package com.clock.zc.mydemo.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.clock.zc.mydemo.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class WaterMarkActivity extends AppCompatActivity {
    @BindView(R.id.image)
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_mark);
        ButterKnife.bind(this);

        Observable.just("http://img1.imgtn.bdimg.com/it/u=911448708,1322942815&fm=27&gp=0.jpg")
                .map(new Function<String, Bitmap>() {//事件的变换，string--》bitmap
                    @Override
                    public Bitmap apply(String s) throws Exception {
                        URL url = new URL(s);
                        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                        InputStream inputStream = urlConnection.getInputStream();
                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                        return bitmap;
                    }
                })
                .map(new Function<Bitmap, Bitmap>() {//事件的变换，bitmap--》加水印的bitmap
                    @Override
                    public Bitmap apply(Bitmap bitmap) throws Exception {
                        bitmap = createWatermark(bitmap,"这是一个大水印");
                        return bitmap;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Bitmap>() {
                    @Override
                    public void accept(Bitmap bitmap) throws Exception {
                        image.setImageBitmap(bitmap);
                    }

                });
    }

    private Bitmap createWatermark(Bitmap bitmap, String mark) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint p = new Paint();
        // 水印颜色
        p.setColor(Color.parseColor("#c500ff00"));
        // 水印字体大小
        p.setTextSize(80);
        //抗锯齿
        p.setAntiAlias(true);
        //绘制图像
        canvas.drawBitmap(bitmap, 0, 0, p);
        //绘制文字
        canvas.drawText(mark, 0, h / 2, p);
        canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.restore();
        return bmp;
    }

    public void obse(){
        Observable.just("nihao")
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) throws Exception {
                        int a=0;
                        if(s.equals("nihao")){
                            a = 1245;
                        }
                        return a;
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
