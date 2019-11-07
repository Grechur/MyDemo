package com.clock.zc.mydemo.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clock.zc.mydemo.R;
import com.clock.zc.mydemo.base.BaseActivity;
import com.clock.zc.mydemo.utils.DensityUtil;
import com.clock.zc.mydemo.view.StatusBarCompat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserCenterActivity extends BaseActivity {

    @BindView(R.id.user_tool_bar)
    Toolbar toolbar;
    @BindView(R.id.title)
    TextView title;
//    @BindView(R.id.recyclerview)
//    RecyclerView recyclerview;
    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsing_toolbar_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_center);
        ButterKnife.bind(this);
        toolbar.setBackgroundColor(Color.TRANSPARENT);
        toolbar.setNavigationIcon(R.mipmap.nav_btn_back_android);
//        recyclerview.setAdapter(new MyAdapter());
        //设置排列方式  上下文 排列方式 是否反转
//        recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        try {
            Class<? extends Activity> act = (Class<? extends Activity>) Class.forName("com.clock.zc.mydemo.ui.MainActivity");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    class MyAdapter extends RecyclerView.Adapter<MyHolder>{

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //recyclerview.xml 简单的textview布局
            View view= View.inflate(getApplicationContext(),R.layout.recyclerview_item,null);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }
    class MyHolder extends RecyclerView.ViewHolder{

        public MyHolder(View itemView) {
            super(itemView);

        }
    }


}
