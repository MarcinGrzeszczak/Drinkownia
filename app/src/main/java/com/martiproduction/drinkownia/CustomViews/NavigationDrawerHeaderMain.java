package com.martiproduction.drinkownia.CustomViews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.martiproduction.drinkownia.R;


import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class NavigationDrawerHeaderMain extends LinearLayout {

    @BindView(R.id.main_drawer_header)
        CustomBubblesAnimation animation;

    @BindView(R.id.main_drawer_userPic)
        CircleImageView userPicture;

    public NavigationDrawerHeaderMain(Context context) {
        super(context);
        init();
    }

    public NavigationDrawerHeaderMain(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NavigationDrawerHeaderMain(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        inflate(getContext(),R.layout.main_drawer_header,this);
        ButterKnife.bind(this);
        Glide
                .with(getContext())
                .load("http://nerdist.com/wp-content/uploads/2016/10/20161025_n_nerdistnews_deadpool2director_1x1.jpg")
                .apply(new RequestOptions().centerCrop().override(100,100))
                .into(userPicture);
    }

    public void setPause(boolean pause){
        animation.setPause(pause);
    }
}
