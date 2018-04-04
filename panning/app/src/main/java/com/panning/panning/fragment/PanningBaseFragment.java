package com.panning.panning.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.panning.panning.R;
import com.panning.panning.view.BizierEvaluator;
import com.panning.panning.view.Point;

/**
 * Created by cloud_wang on 18/4/4.
 */

public class PanningBaseFragment extends AppCompatDialogFragment implements View.OnClickListener {
    private TextView notice;
    private TextView todayProfit;
    private ImageView gold1;
    private ImageView gold2;
    private ImageView gold3;
    private LinearLayout income;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_panning_base, container, false);
        notice = view.findViewById(R.id.notice);
        gold1 = view.findViewById(R.id.gold1);
        gold2 = view.findViewById(R.id.gold2);
        gold3 = view.findViewById(R.id.gold3);
        income = view.findViewById(R.id.income);
        todayProfit = view.findViewById(R.id.todayProfit);
        notice.setText("上淘金，淘到你人生第一桶金～       上淘金，淘到你人生第一桶金～");
        notice.setSelected(true);
        gold1.setOnClickListener(this);
        gold2.setOnClickListener(this);
        gold3.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gold1:
                gold1.setVisibility(View.GONE);
                setAnimation(view);
                break;
            case R.id.gold2:
                gold2.setVisibility(View.GONE);
                setAnimation(view);
                break;
            case R.id.gold3:
                gold3.setVisibility(View.GONE);
                setAnimation(view);
                break;
        }
    }

    private void setAnimation(View view) {
        int[] loc = new int[2];
        view.getLocationInWindow(loc);
        playAnimation(loc);
        try {
            todayProfit.setText(Integer.parseInt(todayProfit.getText().toString()) + 100 + "");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void playAnimation(int[] position) {
        final ImageView mImg = new ImageView(getActivity());
        mImg.setImageResource(R.drawable.circle);
        mImg.setScaleType(ImageView.ScaleType.MATRIX);
        ViewGroup rootView = (ViewGroup) getActivity().getWindow().getDecorView();
        rootView.addView(mImg);

        int[] des = new int[2];
        income.getLocationInWindow(des);

        /*动画开始位置，也就是物品的位置;动画结束的位置，也就是购物车的位置 */
        Point startPosition = new Point(position[0], position[1]);
        Point endPosition = new Point(des[0] + income.getWidth() / 2, des[1] + income.getHeight() / 2);

        int pointX = (startPosition.x + endPosition.x) / 2 - 100;
        int pointY = startPosition.y - 200;
        Point controllPoint = new Point(pointX, pointY);

        /*
        * 属性动画，依靠TypeEvaluator来实现动画效果，其中位移，缩放，渐变，旋转都是可以直接使用
        * 这里是自定义了TypeEvaluator， 我们通过point记录运动的轨迹，然后，物品随着轨迹运动，
        * 一旦轨迹发生变化，就会调用addUpdateListener这个方法，我们不断的获取新的位置，是物品移动
        * */
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new BizierEvaluator(controllPoint), startPosition, endPosition);
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Point point = (Point) valueAnimator.getAnimatedValue();
                mImg.setX(point.x);
                mImg.setY(point.y);
            }
        });

        /**
         * 动画结束，移除掉小圆圈
         */
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                ViewGroup rootView = (ViewGroup) getActivity().getWindow().getDecorView();
                rootView.removeView(mImg);
            }
        });
    }
}
