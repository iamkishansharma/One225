package com.ks.one225.unitFour;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyViews extends View {

    Rect mrect;
    Paint mpaint;
    private static int RECT_SIZE = 500;

    public MyViews(Context context) {
        super(context);
        init(null);
    }

    public MyViews(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MyViews(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public MyViews(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }
    public void init(@Nullable AttributeSet attrs){

        mrect = new Rect();
        mpaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mrect.left = RECT_SIZE;
        mrect.top = RECT_SIZE;
        mrect.bottom = RECT_SIZE + RECT_SIZE;
        mrect.right = mrect.left + RECT_SIZE;
        mpaint.setColor(Color.GREEN);
        canvas.drawRect(mrect,mpaint);
    }
}
