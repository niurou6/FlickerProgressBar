package com.beiing.flikerprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by chenliu on 2016/8/26.<br/>
 * 描述：
 * </br>
 */
public class FlikerProgressBar extends View {

    private int DEFAULT_HEIGHT_DP = 40;

    private Paint textPaint;



    public FlikerProgressBar(Context context) {
        this(context, null, 0);
    }

    public FlikerProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlikerProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(dp2px(1));
        textPaint.setColor(Color.BLUE);
        textPaint.setTextSize(dp2px(12));
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int height = 0;
        switch (heightSpecMode){
            case MeasureSpec.AT_MOST:
                height = (int) dp2px(DEFAULT_HEIGHT_DP);
                break;
            case MeasureSpec.EXACTLY:
            case MeasureSpec.UNSPECIFIED:
                height = heightSpecSize;
                break;
        }
        setMeasuredDimension(widthSpecSize, height);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(0, 0, getWidth(), getHeight(), textPaint);

    }


    private float dp2px(int dp){
        float density = getContext().getResources().getDisplayMetrics().density;
        return dp * density;
    }
}













