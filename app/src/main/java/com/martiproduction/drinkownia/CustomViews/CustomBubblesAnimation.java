package com.martiproduction.drinkownia.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.martiproduction.drinkownia.R;
import com.martiproduction.drinkownia.core.Bubbles;

/**
 * Created by marti on 08.11.2016.
 */

public class CustomBubblesAnimation extends SurfaceView implements Runnable,SurfaceHolder.Callback2 {

    private float bubbleMinSize, bubbbleMaxSize, bubbleMinAcceleration, bubbleMaxAcceleration, bubbleSpeed;
    private int color, bubbleQuantity;
    private Thread thread;
    private Boolean canDraw,firstRun,manualPause;
    private Canvas canvas;
    private Bubbles bubbles;


    public CustomBubblesAnimation(Context context) {
        super(context);
        init(context,null);
    }

    public CustomBubblesAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public CustomBubblesAnimation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    public void setPause(boolean manualPause){
        this.manualPause = manualPause;
    }

    private void init(Context context, AttributeSet attrs){
        getHolder().addCallback(this);
        firstRun = true;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomBubblesAnimation);

        try {
          // background = typedArray.getDrawable(R.styleable.CustomBubblesAnimation_background);
            color = typedArray.getColor(R.styleable.CustomBubblesAnimation_colorBackground,getResources().getColor(R.color.colorDark));
            bubbleQuantity = typedArray.getInt(R.styleable.CustomBubblesAnimation_bubbleQuantity,30);
            bubbleMinSize = typedArray.getFloat(R.styleable.CustomBubblesAnimation_bubbleMinSize,3);
            bubbbleMaxSize = typedArray.getFloat(R.styleable.CustomBubblesAnimation_bubbleMaxSize,6);
            bubbleMinAcceleration = typedArray.getFloat(R.styleable.CustomBubblesAnimation_bubbleMinAcceleration,0.5f);
            bubbleMaxAcceleration = typedArray.getFloat(R.styleable.CustomBubblesAnimation_bubbleMaxAcceleration,2);
            bubbleSpeed = typedArray.getFloat(R.styleable.CustomBubblesAnimation_bubbleSpeed,3);

        }
        finally {
            typedArray.recycle();
        }


    }

    private float toPxs(float dps){
        return dps * getResources().getDisplayMetrics().density;
    }


    @Override
    public void setBackground(Drawable background) {
        super.setBackground(background);
    }

    @Override
    public void surfaceRedrawNeeded(SurfaceHolder holder) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        manualPause = false;
        canDraw = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        canDraw = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread = null;
    }

    @Override
    public void run() {
        while (canDraw){

            if(!getHolder().getSurface().isValid() || manualPause)
                continue;

            canvas = getHolder().lockCanvas();

            if(canvas == null)
                break;

            canvas.drawColor(color);
            if(firstRun){
                firstRun = false;
                bubbles = new Bubbles.Builder()
                        .setBubbleCount(bubbleQuantity) //def 30
                        .setBubbleMinSize((int) toPxs(bubbleMinSize)) //def 3
                        .setBubbleMaxSize((int) toPxs(bubbbleMaxSize)) //def 6
                        .setBubbleMinAcceleration(toPxs(bubbleMinAcceleration)) // def 0.5
                        .setBubbleMaxAcceleration(toPxs(bubbleMaxAcceleration)) // def 2
                        .setBubbleMaxSpeed(toPxs(bubbleSpeed)) // def 3
                        .setCanvas(canvas)
                        .build();
            }
                bubbles.update();

                if (canDraw && canvas != null)
                    getHolder().unlockCanvasAndPost(canvas);
                else
                    break;
        }
    }
}
