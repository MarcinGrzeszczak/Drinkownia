package com.martiproduction.drinkownia.CustomViews;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;

/**
 * Created by marti on 10.11.2016.
 */

public class CustomEditText extends android.support.v7.widget.AppCompatEditText {

    public interface SoftKeyboardListener{
        void SoftKeyboardStatus(boolean show);
    }

    private SoftKeyboardListener softKeyboardListener;
    public CustomEditText(Context context) {
        super(context);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if(softKeyboardListener != null)
            softKeyboardListener.SoftKeyboardStatus(true);
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(softKeyboardListener != null)
            softKeyboardListener.SoftKeyboardStatus(true);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if(softKeyboardListener != null)
            softKeyboardListener.SoftKeyboardStatus(false);
        return super.onKeyPreIme(keyCode, event);
    }

    public void setSoftKeyboardListener(SoftKeyboardListener softKeyboardListener) {
        this.softKeyboardListener = softKeyboardListener;
    }
}
