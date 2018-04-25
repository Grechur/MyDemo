package com.clock.zc.mydemo.ui.fragement;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clock.zc.mydemo.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Zc on 2017/10/18.
 */

@SuppressLint("ValidFragment")
public class TableFragment extends Fragment {
    private String context;
    @BindView(R.id.tl_top)
    TabLayout tl_top;
    @BindView(R.id.view_pager)
    ViewPager view_pager;
    @BindView(R.id.add)
    TextView add;

    private Unbinder unbinder;

    private AdaFragment f1,f2,f3,f4,f5,f6,f7;

    private List<Fragment> fragmentList;
    private String[] titles = { "TAB1", "TAB2", "TAB3", "TAB4", "TAB5", "TAB6", "TAB7" };
    private List<String> tList ;
    private MyPagerAdapter myPagerAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.table_fragment,container,false);
        unbinder = ButterKnife.bind(this, view);
        view_pager.setOffscreenPageLimit(0);
        fragmentList = new ArrayList<Fragment>();
        if(fragmentList!=null){
            fragmentList.add(new BannerFragment());
            fragmentList.add(new AdaFragment("view2"));
            fragmentList.add(new AdaFragment("view3"));
            fragmentList.add(new AdaFragment("view4"));
            fragmentList.add(new AdaFragment("view5"));
            fragmentList.add(new AdaFragment("view6"));
            fragmentList.add(new AdaFragment("view7"));
        }
        tList = new ArrayList<String>(Arrays.asList(titles));
        myPagerAdapter = new MyPagerAdapter(getChildFragmentManager(),fragmentList,tList);
        view_pager.setAdapter(myPagerAdapter);
        tl_top.setupWithViewPager(view_pager);
        tl_top.setTabMode(TabLayout.MODE_SCROLLABLE);
        view_pager.setCurrentItem(4);
        Arrays.sort(titles);
        return view;
    }

    @OnClick({R.id.add})
    void add(View view){
        switch (view.getId()){
            case R.id.add:
                int i = fragmentList.size()+1;
                fragmentList.add(new AdaFragment("view"+i));
                tList.add("TAB"+i);
                myPagerAdapter.notifyDataSetChanged();
                view_pager.setCurrentItem(i);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    public class MyPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;
        private List<String> tList;
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        public MyPagerAdapter(FragmentManager fm,List<Fragment> fragments,List<String> tList) {
            super(fm);
            this.fragments = fragments;
            this.tList = tList;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return tList.get(position);
        }

        @Override
        public int getCount() {
            return tList.size();
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = fragments.get(position);
            if(fragment ==null){
                fragment = new AdaFragment("view"+position);
            }
            return fragment;
        }

    }
}