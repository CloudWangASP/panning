package com.panning.panning.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.panning.panning.R;
import com.panning.panning.adapter.MultiRecyclerAdapter;
import com.panning.panning.model.MarketItem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cloud on 2018/4/2.
 */

public class PanningBaseFragment extends AppCompatDialogFragment {

    private RecyclerView recyclerView;
    private List<MarketItem> mDataList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_panning_base, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(5, 5, 5, 5);
            }
        });
        List<DelegateAdapter.Adapter> adapterList = new LinkedList<>();
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(4);
        linearLayoutHelper.setDividerHeight(1);
        linearLayoutHelper.setMarginBottom(100);

        for (int i = 0; i < 10; i++) {
            MarketItem marketItem = new MarketItem();
            marketItem.type = i % 2 == 0 ? 1 : 2;
            marketItem.lable = "lable" + i;
            mDataList.add(marketItem);
        }
        adapterList.add(new MultiRecyclerAdapter(getActivity(), linearLayoutHelper, mDataList) {
            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                if (holder instanceof LargeImgViewHolder) {
                    LargeImgViewHolder largeImgViewHolder = (LargeImgViewHolder) holder;
                    largeImgViewHolder.largeTitle.setText("上淘金，淘出你人生的第一桶金");
//                    Glide.with(PanningBaseFragment.this).load("http://b254.photo.store.qq.com/psb?/V10IHpOG1tqiS8/KdxmIThxqd9yvciRBhAz3y1qtBSjtamOLT.wvwbLXiE!/b/dP4AAAAAAAAA&bo=VAY4BHAIoAUFCZk!&rf=viewer_4").into(largeImgViewHolder.largeImg);
                } else if (holder instanceof MultiImgViewHolder) {
                    MultiImgViewHolder multiImgViewHolder = (MultiImgViewHolder) holder;
                    multiImgViewHolder.multiTitle.setText("这么多红包，你心不心动？");
//                    Glide.with(PanningBaseFragment.this).load("http://a.hiphotos.baidu.com/image/h%3D300/sign=ea4799136ed0f703f9b293dc38fa5148/faf2b2119313b07eaad49f0c00d7912397dd8c4d.jpg").into(multiImgViewHolder.multiImg1);
//                    Glide.with(PanningBaseFragment.this).load("http://images.17173.com/2016/news/2016/07/22/gxy0722aa14s.jpg").into(multiImgViewHolder.multiImg2);
//                    Glide.with(PanningBaseFragment.this).load("http://pic116.nipic.com/file/20161127/2290814_095001716000_2.jpg").into(multiImgViewHolder.multiImg3);
                }
            }
        });
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager);
        delegateAdapter.setAdapters(adapterList);
        recyclerView.setAdapter(delegateAdapter);
        return view;
    }
}
