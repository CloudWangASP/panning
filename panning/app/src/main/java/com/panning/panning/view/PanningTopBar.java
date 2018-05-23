package com.panning.panning.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.panning.panning.R;

/**
 * Created by cloud_wang on 18/5/23.
 */

public class PanningTopBar extends RelativeLayout {

    private Button leftButton, rightButton;
    private TextView titleView;
    private OnLeftAndRightClickListener listener;

    public interface OnLeftAndRightClickListener {
        void OnLeftBtnClick();

        void OnRightBtnClick();
    }

    public void setOnLeftAndRightClickListener(OnLeftAndRightClickListener listener) {
        this.listener = listener;
    }

    public void setLeftBtnVisiable(boolean flag) {
        leftButton.setVisibility(flag ? View.VISIBLE : View.GONE);
    }

    public void setRightBtnVisiable(boolean flag) {
        rightButton.setVisibility(flag ? View.VISIBLE : View.GONE);
    }

    public PanningTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_topbar, this);
        leftButton = findViewById(R.id.leftButton);
        rightButton = findViewById(R.id.rightButton);
        titleView = findViewById(R.id.titleText);
        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.OnLeftBtnClick();
                }
            }
        });
        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.OnRightBtnClick();
                }
            }
        });

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PanningTopBar);
        int leftBtnBackground = typedArray.getResourceId(R.styleable.PanningTopBar_leftBackGround, 0);
        int rightBtnBackground = typedArray.getResourceId(R.styleable.PanningTopBar_rightBackGround, 0);
        int titleTextColor = typedArray.getColor(R.styleable.PanningTopBar_titleTextColor, 0);
        String titleText = typedArray.getString(R.styleable.PanningTopBar_titleText);
        float titleTextSize = typedArray.getDimension(R.styleable.PanningTopBar_titleTextSize, 0);
        typedArray.recycle();

        leftButton.setBackgroundResource(leftBtnBackground);
        rightButton.setBackgroundResource(rightBtnBackground);
        titleView.setText(titleText);
        titleView.setTextSize(titleTextSize);
        titleView.setTextColor(titleTextColor);
    }

}
