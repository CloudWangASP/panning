package com.panning.panning.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.panning.panning.R;

/**
 * Created by cloud_wang on 18/5/23.
 */

public class PanningItemView extends RelativeLayout {

    private TextView titleView, subTitleView;
    private ImageView titleImg;
    private RelativeLayout itemView;
    private OnPanningItemClickListener listener;

    public void setOnPanningItemClickListener(OnPanningItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnPanningItemClickListener {
        void OnItemClick();
    }

    public PanningItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_item_view, this);
        titleView = findViewById(R.id.titleView);
        subTitleView = findViewById(R.id.subTitleView);
        titleImg = findViewById(R.id.titleImg);
        itemView = findViewById(R.id.itemView);

        itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.OnItemClick();
                }
            }
        });

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PanningItemView);
        float titleTextSize = typedArray.getDimension(R.styleable.PanningItemView_itemTextSize, 0);
        float subTitleTextSize = typedArray.getDimension(R.styleable.PanningItemView_subItemTextSize, 0);
        String titleText = typedArray.getString(R.styleable.PanningItemView_itemText);
        String subTitleText = typedArray.getString(R.styleable.PanningItemView_subItemText);
        int titleTextColor = typedArray.getColor(R.styleable.PanningItemView_itemTextColor, 0);
        int subTitleTextColor = typedArray.getColor(R.styleable.PanningItemView_subItemTextColor, 0);
        int titleImgBackground = typedArray.getResourceId(R.styleable.PanningItemView_rightBackground, 0);
        typedArray.recycle();

        titleImg.setBackgroundResource(titleImgBackground);
        titleView.setText(titleText);
        titleView.setTextColor(titleTextColor);
        titleView.setTextSize(titleTextSize);

        subTitleView.setText(subTitleText);
        subTitleView.setTextColor(subTitleTextColor);
        subTitleView.setTextSize(subTitleTextSize);
    }

    public void setSubTitleViewVisiable(boolean flag) {
        subTitleView.setVisibility(flag ? View.VISIBLE : View.GONE);
    }
}
