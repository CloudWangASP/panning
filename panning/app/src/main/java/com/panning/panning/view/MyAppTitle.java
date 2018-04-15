package com.panning.panning.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.panning.panning.R;

/**
 * Created by cloud_wang on 18/4/15.
 */

public class MyAppTitle extends LinearLayout {

    private OnLeftButtonClickListener mLeftButtonClickListener;
    private OnLeftButton2ClickListener mLeftButton2ClickListener;
    private OnRightButtonClickListener mRightButtonClickListener;
    private OnRightDividerButtonClickListener mRightDividerButtonClickListener;
    private MyViewHolder mViewHolder;
    private View viewAppTitle;

    public MyAppTitle(Context context) {
        super(context);

        init();
    }

    public MyAppTitle(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public MyAppTitle(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        viewAppTitle = inflater.inflate(R.layout.my_widget_app_title, null);
        this.addView(viewAppTitle, layoutParams);

        mViewHolder = new MyViewHolder(this);
        mViewHolder.mLeftButtonWrapperLine.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLeftButtonClickListener != null) {
                    mLeftButtonClickListener.onLeftButtonClick(v);
                }
            }
        });

        mViewHolder.mLeftButton2WrapperLine.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mLeftButton2ClickListener != null) {
                    mLeftButton2ClickListener.onLeftButton2Click(v);
                }
            }
        });

        mViewHolder.mRightButtonWrapperLine.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mRightButtonClickListener != null) {
                    mRightButtonClickListener.OnRightButtonClick(v);
                }
            }
        });

        mViewHolder.mRightDividerImg.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mRightDividerButtonClickListener != null) {
                    mRightDividerButtonClickListener.OnRightDividerButtonClick(v);
                }
            }
        });
    }

    /**
     * 设置背景颜色
     *
     * @param @param color
     * @return void
     * @throws
     */
    public void setAppBackground(int color) {
        viewAppTitle.setBackgroundColor(color);
    }

    public void setLeftButton(int leftButtonDrawableId, String title) {
        if (leftButtonDrawableId > 0) {
            mViewHolder.mLeftButtonImg.setImageResource(leftButtonDrawableId);
        }
        if (!TextUtils.isEmpty(title)) {
            mViewHolder.mLeftTitleTv.setText(title);
        }
    }

    public void setRightButton(int rightButtonDrawableId, String title) {
        if (rightButtonDrawableId > 0) {
            mViewHolder.mRightButtonImg.setImageResource(rightButtonDrawableId);
        }
        if (!TextUtils.isEmpty(title)) {
            mViewHolder.mRightButtonTv.setText(title);
        }
    }

    public void setLeftButton2(int leftButton2WrapperBackgroundDrawableId, int leftButton2DrawableId, String title) {
        if (leftButton2DrawableId > 0) {
            mViewHolder.mLeftButton2Img.setImageResource(leftButton2DrawableId);
        }
        if (!TextUtils.isEmpty(title)) {
            mViewHolder.mLeftTitle2Tv.setText(title);
        }
        if (leftButton2WrapperBackgroundDrawableId > 0) {
            mViewHolder.mLeftButton2InnerWrapperLine.setBackgroundResource(leftButton2WrapperBackgroundDrawableId);
        }
    }

    public void setRightButtonTitleOrImage(Boolean isOnlyText, String title, int imageDrawableId) {
        if (isOnlyText) {
            mViewHolder.mRightButtonTv.setText(title);
            if (title.length() >= 6) {
                mViewHolder.mRightButtonTv.setTextSize(14);
            }
        } else {
            if (imageDrawableId >= 0) {
                mViewHolder.mRightButtonTv.setCompoundDrawablesWithIntrinsicBounds(imageDrawableId, 0, 0, 0);
            }
        }
    }

    public void setRightDividerButton(int rightDividerButtonDrawableId) {
        if (rightDividerButtonDrawableId > 0) {
            mViewHolder.mRightDividerImg.setImageResource(rightDividerButtonDrawableId);
        }
    }

    public void setAppTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            mViewHolder.mAppTitleTv.setText(title);
        }
    }

    public void setAppTitleColor(int color) {
        if (color != 0) {
            mViewHolder.mAppTitleTv.setTextColor(color);
        }
    }

    public void setAppTitleBackground(int resId) {
        if (resId != 0) {
            mViewHolder.mRootView.setBackgroundResource(resId);
        }
    }

    public void initViewsVisible(Boolean isLeftButtonVisible, Boolean isLeftButton2visible, Boolean isTitleVisible, Boolean isRightDividerVisible, Boolean isRightButtonVisible) {
        if (isLeftButtonVisible)
            mViewHolder.mLeftButtonWrapperLine.setVisibility(View.VISIBLE);
        else
            mViewHolder.mLeftButtonWrapperLine.setVisibility(View.GONE);

        if (isLeftButton2visible)
            mViewHolder.mLeftButton2WrapperLine.setVisibility(View.VISIBLE);
        else
            mViewHolder.mLeftButton2WrapperLine.setVisibility(View.GONE);

        if (isTitleVisible)
            mViewHolder.mAppTitleTv.setVisibility(View.VISIBLE);
        else
            mViewHolder.mAppTitleTv.setVisibility(View.GONE);

        if (isRightDividerVisible)
            mViewHolder.mRightDividerImg.setVisibility(View.VISIBLE);
        else
            mViewHolder.mRightDividerImg.setVisibility(View.GONE);

        if (isRightButtonVisible)
            mViewHolder.mRightButtonWrapperLine.setVisibility(View.VISIBLE);
        else
            mViewHolder.mRightButtonWrapperLine.setVisibility(View.GONE);
    }

    public void setOnLeftButtonClickListener(OnLeftButtonClickListener listen) {
        mLeftButtonClickListener = listen;
    }

    public void setOnLeftButton2ClickListener(OnLeftButton2ClickListener listen) {
        mLeftButton2ClickListener = listen;
    }

    public void setOnRightButtonClickListener(OnRightButtonClickListener listen) {
        mRightButtonClickListener = listen;
    }

    public void setOnRightDividerButtonClickListener(OnRightDividerButtonClickListener listen) {
        mRightDividerButtonClickListener = listen;
    }

    public TextView getRightButton() {
        return mViewHolder.mRightButtonTv;
    }

    static class MyViewHolder {
        View mRootView;
        LinearLayout mLeftButtonWrapperLine;
        ImageView mLeftButtonImg;
        TextView mLeftTitleTv;
        LinearLayout mLeftButton2WrapperLine;
        LinearLayout mLeftButton2InnerWrapperLine;
        ImageView mLeftButton2Img;
        TextView mLeftTitle2Tv;
        TextView mAppTitleTv;
        ImageView mRightDividerImg;
        LinearLayout mRightButtonWrapperLine;
        TextView mRightButtonTv;
        ImageView mRightButtonImg;

        public MyViewHolder(View v) {
            mRootView = v.findViewById(R.id.myapptitle_rootview);
            mLeftButtonWrapperLine = v.findViewById(R.id.myapptitle_leftbutton_wrapper);
            mLeftButtonImg = v.findViewById(R.id.myapptitle_leftbutton_image);
            mRightButtonImg = v.findViewById(R.id.myapptitle_Rightbutton_image);
            mLeftTitleTv = v.findViewById(R.id.myapptitle_LeftTitle);
            mLeftButton2WrapperLine = v.findViewById(R.id.myapptitle_leftbutton2_wrapper);
            mLeftButton2InnerWrapperLine = v.findViewById(R.id.myapptitle_leftbutton2_inner_wrapper);
            mLeftButton2Img = v.findViewById(R.id.myapptitle_leftbutton2_image);
            mLeftTitle2Tv = v.findViewById(R.id.myapptitle_leftbutton2_textview);
            mAppTitleTv = v.findViewById(R.id.myapptitle_Title);
            mRightDividerImg = v.findViewById(R.id.myapptitle_Divider1_imageview);
            mRightButtonWrapperLine = v.findViewById(R.id.myapptitle_RightButtonWrapper);
            mRightButtonTv = v.findViewById(R.id.myapptitle_RightButton_textview);
        }
    }

    public static abstract interface OnLeftButtonClickListener {
        public abstract void onLeftButtonClick(View v);
    }

    public static abstract interface OnLeftButton2ClickListener {
        public abstract void onLeftButton2Click(View v);
    }

    public static abstract interface OnRightButtonClickListener {
        public abstract void OnRightButtonClick(View v);
    }

    public static abstract interface OnRightDividerButtonClickListener {
        public abstract void OnRightDividerButtonClick(View v);
    }
}
