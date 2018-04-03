package com.panning.panning.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.panning.panning.R;
import com.panning.panning.adapter.CustomFragmentPagerAdapter;
import com.panning.panning.fragment.PanningBaseFragment;
import com.panning.panning.fragment.PanningRecyclerFragment;
import com.panning.panning.fragment.PanningMarketFragment;
import com.panning.panning.view.MainViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mainTabLayout;
    private MainViewPager mainViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTabLayout = findViewById(R.id.mainTabLayout);
        mainViewPager = findViewById(R.id.mainViewPager);

        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new PanningBaseFragment());
        fragmentArrayList.add(new PanningMarketFragment());

        CustomFragmentPagerAdapter customFragmentPagerAdapter = new CustomFragmentPagerAdapter(getSupportFragmentManager());
        customFragmentPagerAdapter.setFragments(fragmentArrayList);
        mainViewPager.setAdapter(customFragmentPagerAdapter);
        mainViewPager.setScanScroll(false);
        mainViewPager.setOffscreenPageLimit(mainViewPager.getChildCount());

        mainTabLayout.addTab(mainTabLayout.newTab());
        mainTabLayout.addTab(mainTabLayout.newTab());

        mainTabLayout.setupWithViewPager(mainViewPager);
        mainTabLayout.getTabAt(0).setText("淘金基地");
        mainTabLayout.getTabAt(1).setText("去淘金");
        mainTabLayout.setSelectedTabIndicatorColor(Color.TRANSPARENT);
    }
}
