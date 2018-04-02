package com.panning.panning.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cloud on 2018/4/2.
 */

public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList;

    public void setFragments(ArrayList<Fragment> fragments) {
        this.mFragmentList = fragments;
    }

    public CustomFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
