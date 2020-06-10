package com.ks.one225.unitFour;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.ks.one225.R;

public class KishanText extends AppCompatTextView {
    private String mTitle;
    private int mColor;
    private int mSize;

    public KishanText(Context context) {
        super(context);
    }

    public KishanText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.KishanText);
        try {
            mTitle = typedArray.getString(R.styleable.KishanText_KishanAddText);
            assert mTitle != null;
            if(mTitle.equals("")){
                setText("");
            }else {
                setText(mTitle);
            }

            mColor = typedArray.getColor(R.styleable.KishanText_KishanSetColor, Color.WHITE);
            if(mColor!=0){
                setTextColor(mColor);
            }else{
                setTextColor(Color.WHITE);
            }

            mSize = typedArray.getDimensionPixelSize(R.styleable.KishanText_KishanAddSize,16);
            if(mSize!=0){
                setTextSize(mSize);
            }else{
                setTextSize(0);
            }

        }finally {
            typedArray.recycle();
        }
    }



    public KishanText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
