package com.martiproduction.drinkownia.Fragments;

import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.martiproduction.drinkownia.R;


/**
 * Created by marcin on 19.09.2017.
 */

public class PopupTitle {

    private PopupWindow mPopupWindow;
    private View mParentConatiner;
    private TextView mPopupText;



    public PopupTitle(Context context, View parentContainer){
        mParentConatiner = parentContainer;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_popup_window,null,false);
        mPopupText = (TextView) view.findViewById(R.id.popupWindow_text);
        mPopupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,300,false);
        mPopupWindow.setAnimationStyle(R.style.PopupAnimationStyle);
    }

    public void show(String text){
        mPopupText.setText(text);
        mPopupWindow.showAtLocation(mParentConatiner, Gravity.NO_GRAVITY,0,0);
    }

    public void show(String text,int seconds){

        Handler timeHandler = new Handler();
        Runnable timeRunnable = PopupTitle.this::dismiss;



        this.show(text);
        timeHandler.postDelayed(timeRunnable,seconds*1000);

       // timeHandler.removeCallbacks(timeRunnable);


    }

    public void dismiss(){
        mPopupWindow.dismiss();
    }

    public void destroy(){

        if(mPopupWindow != null)
            mPopupWindow = null;

        if(mParentConatiner != null)
            mParentConatiner = null;
    }
}
