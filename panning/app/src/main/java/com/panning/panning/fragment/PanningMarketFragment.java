package com.panning.panning.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.panning.panning.R;
import com.panning.panning.adapter.CustomFragmentPagerAdapter;
import com.panning.panning.view.MainViewPager;

import java.util.ArrayList;

/**
 * Created by cloud on 2018/4/2.
 */

public class PanningMarketFragment extends AppCompatDialogFragment {

    private TabLayout marketTabLayout;
    private MainViewPager marketViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_panning_market, container, false);
        marketTabLayout = view.findViewById(R.id.marketTabLayout);
        marketViewPager = view.findViewById(R.id.marketViewPager);

        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            fragmentArrayList.add(new PanningBaseFragment());
        }
        CustomFragmentPagerAdapter customFragmentPagerAdapter = new CustomFragmentPagerAdapter(getChildFragmentManager());
        customFragmentPagerAdapter.setFragments(fragmentArrayList);
        marketViewPager.setAdapter(customFragmentPagerAdapter);
        marketViewPager.setOffscreenPageLimit(8);
        marketTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 0; i < 8; i++) {
            marketTabLayout.addTab(marketTabLayout.newTab());
        }
        marketTabLayout.setupWithViewPager(marketViewPager);
        for (int i = 0; i < 8; i++) {
            marketTabLayout.getTabAt(i).setText("领红包");
        }
        return view;
    }
}
