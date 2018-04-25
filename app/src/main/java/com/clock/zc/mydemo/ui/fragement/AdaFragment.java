package com.clock.zc.mydemo.ui.fragement;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clock.zc.mydemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Zc on 2017/10/18.
 */

@SuppressLint("ValidFragment")
public class AdaFragment extends Fragment {
    private String context;
    @BindView(R.id.txt_content)
    TextView mTextView;
    private Unbinder unbinder;
    public AdaFragment(String context){
        this.context = context;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser && isVisible()){
            setDatas();//获取数据
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment,container,false);
        unbinder = ButterKnife.bind(this, view);
        mTextView.setText(context);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void setDatas() {

    }

}