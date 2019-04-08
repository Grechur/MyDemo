package com.clock.zc.mydemo.ui.fragement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.clock.zc.mydemo.R;
import com.clock.zc.mydemo.adapter.ZoomRecycleAdapter;
import com.clock.zc.mydemo.ui.ImageActivity;
import com.clock.zc.mydemo.utils.glide.GlideCircleTransform;
import com.clock.zc.mydemo.utils.glide.GlideImageLoaderStrategy;
import com.clock.zc.mydemo.utils.glide.ImageConfigImpl;
import com.clock.zc.mydemo.utils.glide.ImageLoader;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Zc on 2017/10/25.
 */

@SuppressLint("ValidFragment")
public class BannerFragment  extends Fragment {
    @BindView(R.id.txt_content)
    TextView mTextView;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private Unbinder unbinder;
    private ArrayList<String> mDatas;
    private ZoomRecycleAdapter mAdapter;
    private View headerView;
    int[] RES = {
            R.mipmap.image1,R.mipmap.image2,R.mipmap.image3,R.mipmap.image4,R.mipmap.image5
    };
    private MZBannerView mMZBanner;
    private SoundPool mSoundPool;


    @SuppressLint("ResourceType")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.banner_fragment,container,false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        headerView = LayoutInflater.from(getActivity()).inflate(R.layout.banner_layout,null);

        mMZBanner = (MZBannerView) headerView.findViewById(R.id.banner);

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<RES.length;i++){
            list.add(RES[i]);
        }
        // 设置数据
        mMZBanner.setPages(list, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
        
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter = new ZoomRecycleAdapter(getActivity(), (ArrayList<String>) mDatas,headerView));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL));


        createSoundPoolIfNeeded();
        return view;
    }

    /**
     * 创建SoundPool ，注意 api 等级
     */
    private void createSoundPoolIfNeeded(){
        if (mSoundPool == null) {
            // 5.0 及 之后
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                AudioAttributes audioAttributes = null;
                audioAttributes = new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .build();

                mSoundPool = new SoundPool.Builder()
                        .setMaxStreams(1)
                        .setAudioAttributes(audioAttributes)
                        .build();
            } else { // 5.0 以前
                mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);  // 创建SoundPool
            }
        }
    }
    public static class BannerViewHolder implements MZViewHolder<Integer> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局文件
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item,null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            // 数据绑定
            mImageView.setImageResource(data);
        }
    }
    @OnClick({R.id.txt_content})
    void loadApk(View view){
//        startActivity(new Intent(getActivity(), ImageActivity.class));
        if(mSoundPool != null){
            int id = mSoundPool.load(getActivity(),R.raw.push,5);
            mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                @Override
                public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                    mSoundPool.play(id,1, 1, 0,0,1);
                }
            });
        }

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMZBanner.start();

    }

    @Override
    public void onPause() {
        super.onPause();
        mMZBanner.pause();//暂停轮播
        mMZBanner.destroyDrawingCache();
        if(mSoundPool!=null){
            mSoundPool.release();
            mSoundPool = null;
        }
    }

    protected void initData()
    {
        mDatas = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            mDatas.add("" + i);
        }
    }
    
}
