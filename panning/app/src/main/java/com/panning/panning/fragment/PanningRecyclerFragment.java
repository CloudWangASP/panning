package com.panning.panning.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.VideoView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.panning.panning.R;
import com.panning.panning.activity.VideoActivity;
import com.panning.panning.adapter.MultiRecyclerAdapter;
import com.panning.panning.application.GlideApp;
import com.panning.panning.model.MarketItem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cloud on 2018/4/2.
 */
public class PanningRecyclerFragment extends AppCompatDialogFragment {

    private RecyclerView recyclerView;
    private List<MarketItem> mDataList = new ArrayList<>();
    private MultiRecyclerAdapter multiRecyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_panning_recycler, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        List<DelegateAdapter.Adapter> adapterList = new LinkedList<>();
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(4);

        for (int i = 0; i < 10; i++) {
            MarketItem marketItem = new MarketItem();
            switch (i % 3) {
                case 0:
                    marketItem.type = 1;
                    break;
                case 1:
                    marketItem.type = 2;
                    break;
                case 2:
                    marketItem.type = 3;
                    break;
            }
            marketItem.lable = "lable" + i;
            mDataList.add(marketItem);
        }
        multiRecyclerAdapter = new MultiRecyclerAdapter(getActivity(), linearLayoutHelper, mDataList) {
            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                if (holder instanceof LargeImgViewHolder) {
                    LargeImgViewHolder largeImgViewHolder = (LargeImgViewHolder) holder;
                    largeImgViewHolder.largeTitle.setText("上淘金，淘出你人生的第一桶金");
                    GlideApp.with(getActivity()).load("https://p3.pstatp.com/weili/l/55310545896739970.jpg").placeholder(R.mipmap.large_placeholder).centerCrop().into(largeImgViewHolder.largeImg);
                } else if (holder instanceof MultiImgViewHolder) {
                    MultiImgViewHolder multiImgViewHolder = (MultiImgViewHolder) holder;
                    multiImgViewHolder.multiTitle.setText("这么多红包，你心不心动？");
                    GlideApp.with(getActivity()).load("http://a.hiphotos.baidu.com/image/h%3D300/sign=ea4799136ed0f703f9b293dc38fa5148/faf2b2119313b07eaad49f0c00d7912397dd8c4d.jpg").placeholder(R.mipmap.normal_placeholder).centerCrop().into(multiImgViewHolder.multiImg1);
                    GlideApp.with(getActivity()).load("https://p3a.pstatp.com/weili/l/236436205980495020.jpg").placeholder(R.mipmap.normal_placeholder).centerCrop().into(multiImgViewHolder.multiImg2);
                    GlideApp.with(getActivity()).load("https://p9.pstatp.com/weili/l/256558179286253762.jpg").placeholder(R.mipmap.normal_placeholder).centerCrop().into(multiImgViewHolder.multiImg3);
                } else if (holder instanceof VideoTextViewHolder) {
                    VideoTextViewHolder videoTextViewHolder = (VideoTextViewHolder) holder;
                    videoTextViewHolder.videoTitle.setText("曾经有一个捡钱的机会放在你面前，你没有珍惜，直到失去才后悔莫及");
                    GlideApp.with(getActivity()).load("https://p3.pstatp.com/weili/l/236442072905815973.jpg").placeholder(R.mipmap.normal_placeholder).centerCrop().into(videoTextViewHolder.videoImg);
                }
            }
        };
        adapterList.add(multiRecyclerAdapter);
        multiRecyclerAdapter.setOnItemClickListener(new MultiRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(getActivity(), VideoActivity.class);
                startActivity(intent);
            }
        });

        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager);
        delegateAdapter.setAdapters(adapterList);
        recyclerView.setAdapter(delegateAdapter);
        return view;
    }
}
