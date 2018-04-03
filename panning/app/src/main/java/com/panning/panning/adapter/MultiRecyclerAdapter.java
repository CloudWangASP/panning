package com.panning.panning.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
    private final int VIDEO_IMG = 3;

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
            case 3:
                return VIDEO_IMG;
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
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_multi_image, parent, false);
                return new MultiImgViewHolder(view);
            case 3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_video_text, parent, false);
                return new VideoTextViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static class LargeImgViewHolder extends RecyclerView.ViewHolder {
        public TextView largeTitle;
        public ImageView largeImg;

        public LargeImgViewHolder(View itemView) {
            super(itemView);
            largeTitle = itemView.findViewById(R.id.largeTitle);
            largeImg = itemView.findViewById(R.id.largeImg);
        }
    }

    public static class MultiImgViewHolder extends RecyclerView.ViewHolder {
        public TextView multiTitle;
        public ImageView multiImg1;
        public ImageView multiImg2;
        public ImageView multiImg3;

        public MultiImgViewHolder(View itemView) {
            super(itemView);
            multiTitle = itemView.findViewById(R.id.multiTitle);
            multiImg1 = itemView.findViewById(R.id.multiImg1);
            multiImg2 = itemView.findViewById(R.id.multiImg2);
            multiImg3 = itemView.findViewById(R.id.multiImg3);
        }
    }

    public static class VideoTextViewHolder extends RecyclerView.ViewHolder {
        public TextView videoTitle;
        public ImageView videoImg;

        public VideoTextViewHolder(View itemView) {
            super(itemView);
            videoTitle = itemView.findViewById(R.id.videoTitle);
            videoImg = itemView.findViewById(R.id.videoImg);
        }
    }
}
