package com.martiproduction.drinkownia.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.martiproduction.drinkownia.R;
import com.martiproduction.drinkownia.core.RecipeInfo;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class RecipeDetailsTitle extends Fragment {

    @BindView(R.id.title_drink_name)
     TextView drinkName;

    @BindView(R.id.title_drink_pic)
     ImageView drinkPic;

    @BindView(R.id.title_favourite_btn)
     ImageView favBtn;

    @BindView(R.id.title_ratingbar)
     RatingBar ratingBar;


    private RecipeInfo recipeInfo;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.adapter_drink_title,container,false);
        unbinder = ButterKnife.bind(this,view);

        if(recipeInfo != null){
            drinkName.setText(recipeInfo.getName());
            ratingBar.setRating(recipeInfo.getRating());

            Picasso
                    .with(getActivity().getApplicationContext())
                    .load(recipeInfo.getPicSrc())
                    .resize(80,80).centerCrop()
                    .into(drinkPic);


        }

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void setRecipeInfo(RecipeInfo recipeInfo) {
        this.recipeInfo = recipeInfo;
    }


}
