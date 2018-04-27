package com.clock.zc.mydemo.ui.fragement;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.clock.zc.mydemo.R;
import com.clock.zc.mydemo.http.retrofitdownload.DownInfo;
import com.clock.zc.mydemo.http.retrofitdownload.DownLoadManager;
import com.clock.zc.mydemo.http.retrofitdownload.DownState;
import com.clock.zc.mydemo.http.retrofitdownload.HttpDownOnNextListener;
import com.clock.zc.mydemo.utils.DbDownUtil;
import com.daimajia.numberprogressbar.NumberProgressBar;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Zc on 2017/10/18.
 */

@SuppressLint("ValidFragment")
public class FirstFragment extends Fragment {
    private String context = "";
    @BindView(R.id.txt_content)
    TextView mTextView;
    @BindView(R.id.btn_rx_down)
    Button btn_rx_down;
    @BindView(R.id.btn_rx_pause)
    Button btn_rx_pause;
    @BindView(R.id.tv_msg)
    TextView tv_msg;
    @BindView(R.id.number_progress_bar)
    NumberProgressBar number_progress_bar;

    private DownInfo apkApi;
    private DbDownUtil dbUtil;
    private DownLoadManager manager;

    private Unbinder unbinder;
    public  FirstFragment(){
    }
    public  FirstFragment(String context){
        this.context = context;
    }
    boolean isPuse = false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment,container,false);
        unbinder = ButterKnife.bind(this, view);
        mTextView.setText(context);
        manager = DownLoadManager.getInstance();
        dbUtil= DbDownUtil.getInstance();
        apkApi = new DownInfo();
        String downUrl = "Grechur/PunchTheClock/archive/master.zip";

        File outputFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                "test"+1 + ".apk");
        apkApi.setId(10);
        apkApi.setUrl(downUrl);
        apkApi.setState(DownState.START);
        apkApi.setSavePath(outputFile.getAbsolutePath());
        apkApi.setListener(httpProgressOnNextListener);
        dbUtil.save(apkApi);
        number_progress_bar.setMax((int) apkApi.getCountLength());
        number_progress_bar.setProgress((int) apkApi.getReadLength());
        /*第一次恢复 */
        switch (apkApi.getState()){
            case START:
                /*起始状态*/
                break;
            case PAUSE:
                tv_msg.setText("暂停中");
                isPuse = true;
                break;
            case DOWN:
                isPuse = false;
                manager.startDown(apkApi);
                break;
            case STOP:
                tv_msg.setText("下载停止");
                break;
            case ERROR:
                tv_msg.setText("下載錯誤");
                break;
            case  FINISH:
                tv_msg.setText("下载完成");
                break;
        }

        return view;
    }
    /*下载回调*/
    HttpDownOnNextListener<DownInfo> httpProgressOnNextListener=new HttpDownOnNextListener<DownInfo>() {
        @Override
        public void onNext(DownInfo baseDownEntity) {
            tv_msg.setText("提示：下载完成");
            Toast.makeText(getContext(),baseDownEntity.getSavePath(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStart() {
            isPuse = true;
            tv_msg.setText("提示:开始下载");
        }

        @Override
        public void onComplete() {
            tv_msg.setText("提示：下载结束");
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            tv_msg.setText("失败:"+e.toString());
        }


        @Override
        public void onPuase() {
            super.onPuase();
            isPuse = true;
            tv_msg.setText("提示:暂停");
        }

        @Override
        public void onStop() {
            super.onStop();
        }

        @Override
        public void updateProgress(long readLength, long countLength) {
            tv_msg.setText("提示:下载中");
            number_progress_bar.setMax((int) countLength);
            number_progress_bar.setProgress((int) readLength);
        }
    };

    @OnClick({R.id.btn_rx_down,R.id.btn_rx_pause})
    void click(View view){
        switch (view.getId()){
            case R.id.btn_rx_down:
                if(isPuse){
                    DownInfo a = dbUtil.queryDownBy(apkApi.getId());
                    apkApi = a;
                    apkApi.setListener(httpProgressOnNextListener);
                    apkApi.getListener().updateProgress(apkApi.getReadLength(),apkApi.getCountLength());
                }
                if(apkApi.getState()!= DownState.FINISH){
                    manager.startDown(apkApi);
                }
                break;
            case R.id.btn_rx_pause:
                manager.pause(apkApi);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}