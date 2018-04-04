package com.panning.panning.view;

import android.animation.TypeEvaluator;

/**
 * Created by cloud on 2018/4/4.
 * 贝塞尔曲线（二阶抛物线）
 * controllPoint 是中间的转折点
 * startValue 是起始的位置
 * endValue 是结束的位置
 */
public class BizierEvaluator implements TypeEvaluator<Point> {

    private Point controllPoint;

    public BizierEvaluator(Point controllPoint) {
        this.controllPoint = controllPoint;
    }

    @Override
    public Point evaluate(float t, Point startValue, Point endValue) {
        int x = (int) ((1 - t) * (1 - t) * startValue.x + 2 * t * (1 - t) * controllPoint.x + t * t * endValue.x);
        int y = (int) ((1 - t) * (1 - t) * startValue.y + 2 * t * (1 - t) * controllPoint.y + t * t * endValue.y);
        return new Point(x, y);
    }
}