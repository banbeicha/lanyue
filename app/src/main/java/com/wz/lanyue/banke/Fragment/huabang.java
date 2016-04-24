package com.wz.lanyue.banke.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wz.lanyue.banke.R;
import com.wz.lanyue.banke.data.ShouYeAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by BANBEICHA on 2016/3/28.
 */
public class huabang extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    List<Fragment> fragmentList;
    List<String> title;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=  inflater.inflate(R.layout.huabang,container,false);
        initViewData(view);
        return view;
    }

    private void initViewData(View view) {
        title = new ArrayList<String>();
        fragmentList=new ArrayList<Fragment>();
        tabLayout= (TabLayout) view.findViewById(R.id.huabangtablayout);
        viewPager= (ViewPager) view.findViewById(R.id.huabangviewpager);
        title.add("全部");
        title.add("内地");
        title.add("港台");
        title.add("欧美");
        title.add("韩国");
        title.add("日本");
        fragmentList.add(new HuangBangALL());
        fragmentList.add(new HuangBangML());
        fragmentList.add(new HuangBangHT());
        fragmentList.add(new HuangBangUS());
        fragmentList.add(new HuangBangKR());
        fragmentList.add(new HuangBangJP());
        for (int i=0;i<title.size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(title.get(i)));
        }
        viewPager.setAdapter(new ShouYeAdapter(getChildFragmentManager(),fragmentList,title));
        tabLayout.setupWithViewPager(viewPager);
    }



}
