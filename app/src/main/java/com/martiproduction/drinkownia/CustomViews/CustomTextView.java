package com.martiproduction.drinkownia.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.martiproduction.drinkownia.R;

/**
 * Created by Marcin on 02.03.2017.
 */

public class CustomTextView extends android.support.v7.widget.AppCompatTextView {

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setExternalFont(context,attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setExternalFont(context,attrs);
    }

    private void setExternalFont(Context context , AttributeSet attrs){

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        try{
            final String externalFont = typedArray.getString(R.styleable.CustomTextView_external_font);
            Typeface typeface = Typeface.createFromAsset(context.getAssets(),externalFont);
            setTypeface(typeface);
        }
        finally {
            typedArray.recycle();
        }
    }

}
