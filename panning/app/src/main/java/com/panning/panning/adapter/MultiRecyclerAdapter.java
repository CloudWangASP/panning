package com.panning.panning.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.panning.panning.R;
import com.panning.panning.model.MarketItem;

import java.util.List;

/**
 * Created by cloud on 2018/4/2.
 */

public class MultiRecyclerAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {

    private final int LARGE_IMG = 1;
    private final int MULTI_IMG = 2;

    private Context mContext;
    private LayoutHelper mLayoutHelper;
    private List<MarketItem> mDataList;

    public MultiRecyclerAdapter(Context context, LayoutHelper layoutHelper, List<MarketItem> dataList) {
        this.mContext = context;
        this.mLayoutHelper = layoutHelper;
        this.mDataList = dataList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (mDataList.get(position).type) {
            case 1:
                return LARGE_IMG;
            case 2:
                return MULTI_IMG;
        }
        return super.getItemViewType(position);
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mLayoutHelper;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_large_image, parent, false);
                return new LargeImgViewHolder(view);
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_large_image, parent, false);
                return new MultiImgViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if (holder instanceof LargeImgViewHolder) {
//            LargeImgViewHolder largeImgViewHolder = (LargeImgViewHolder) holder;
//            largeImgViewHolder.tv.setText("DSFSDFSDFSD");
//        } else if (holder instanceof MultiImgViewHolder) {
//            MultiImgViewHolder multiImgViewHolder = (MultiImgViewHolder) holder;
//            multiImgViewHolder.tv.setText("fsdfsdsfsdf");
//        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static class LargeImgViewHolder extends RecyclerView.ViewHolder {
        public ImageView largeImg;

        public LargeImgViewHolder(View itemView) {
            super(itemView);
            largeImg = itemView.findViewById(R.id.largeImg);
        }
    }

    public static class MultiImgViewHolder extends RecyclerView.ViewHolder {
        public ImageView largeImg;

        public MultiImgViewHolder(View itemView) {
            super(itemView);
            largeImg = itemView.findViewById(R.id.largeImg);
        }
    }
}
