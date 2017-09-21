package com.martiproduction.drinkownia.UI;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.martiproduction.drinkownia.CustomViews.CustomBubblesAnimation;
import com.martiproduction.drinkownia.CustomViews.CustomTextView;
import com.martiproduction.drinkownia.Fragments.RecipeDetailsDirections;
import com.martiproduction.drinkownia.Fragments.RecipeDetailsGlassType;
import com.martiproduction.drinkownia.Fragments.RecipeDetailsIngredients;
import com.martiproduction.drinkownia.Fragments.RecipeDetailsTags;
import com.martiproduction.drinkownia.R;
import com.martiproduction.drinkownia.core.RecipeInfo;


public class RecipeDetails extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    private CustomBubblesAnimation bubblesAnimation;
    private RelativeLayout expandedToolbarContent;
    private boolean startAnimation;
    private Toolbar toolbar;

    @Override
    public void onBackPressed() {

        startActivity(new Intent(RecipeDetails.this,Main.class));
        finish();

        super.onBackPressed();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.recipe_details_menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recpie_details);

        startAnimation = false;

        RecipeInfo recipeInfo = getIntent().getParcelableExtra("RecipeInfo");
        expandedToolbarContent = (RelativeLayout) findViewById(R.id.details_expandedToolbarContent);
        bubblesAnimation = (CustomBubblesAnimation) findViewById(R.id.details_expandedToolbarContent_bubbleAnimation);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.details_appBar);

        appBarLayout.addOnOffsetChangedListener(this);

        toolbar = (Toolbar) findViewById(R.id.details_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setSubtitle("");

        ImageView smallImageView = (ImageView) findViewById(R.id.details_toolbar_drinkImage);
        CustomTextView smallDrinkName = (CustomTextView) findViewById(R.id.details_toolbar_title);

        ImageView imageView = (ImageView) findViewById(R.id.details_expandedToolbarContent_title_drinkImage);
        CustomTextView drinkName = (CustomTextView) findViewById(R.id.details_expandedToolbarContent_title_drinkName);
        

        drinkName.setText(recipeInfo.getName());
        smallDrinkName.setText(recipeInfo.getName());


        RequestOptions requestOptions = new RequestOptions()
                .centerCrop()
                .override(100,100);

        Glide.with(this)
                .load(recipeInfo.getPicSrc())
                .apply(requestOptions)
                .into(imageView);

        Glide.with(this)
                .load(recipeInfo.getPicSrc())
                .apply(requestOptions)
                .into(smallImageView);


        RecipeDetailsGlassType recipeDetailsGlassType = new RecipeDetailsGlassType();
        getFragmentManager().beginTransaction().add(R.id.details_glassType_fragment,recipeDetailsGlassType).commit();

        RecipeDetailsIngredients recipeDetailsIngredients = new RecipeDetailsIngredients();
        getFragmentManager().beginTransaction().add(R.id.details_ingredients_fragment,recipeDetailsIngredients).commit();

        RecipeDetailsDirections recipeDetailsDirections = new RecipeDetailsDirections();
        getFragmentManager().beginTransaction().add(R.id.details_directions_fragment,recipeDetailsDirections).commit();

        RecipeDetailsTags recipeDetailsTags = new RecipeDetailsTags();
        getFragmentManager().beginTransaction().add(R.id.details_tags_fragment,recipeDetailsTags).commit();

    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

        if(verticalOffset < 0) {
            bubblesAnimation.setPause(true);
            toolbar.setVisibility(View.VISIBLE);
        }
        else {
            bubblesAnimation.setPause(false);
            toolbar.setVisibility(View.GONE);
            startAnimation = true;
        }

        if(Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange())
            startAnimation = true;

        if(startAnimation) {

            startAnimation = false;

            if ((Math.abs(verticalOffset) / appBarLayout.getTotalScrollRange()) <= 0.3f) {
                fadeAnimation(true);
                Log.d("Animation", "started");
            } else
                fadeAnimation(false);
        }

    }



    private void fadeAnimation(boolean fadeout){

        AlphaAnimation alphaAnimation = (fadeout)? new AlphaAnimation(0f,1f) : new AlphaAnimation(1f,0f);
        alphaAnimation.setDuration(300);
        alphaAnimation.setFillAfter(true);
        expandedToolbarContent.startAnimation(alphaAnimation);

    }

}
