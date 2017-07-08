package com.martiproduction.drinkownia.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.martiproduction.drinkownia.UI.RecipeDetails;
import com.martiproduction.drinkownia.core.RecipeInfo;
import com.martiproduction.drinkownia.CustomViews.RecipesListAdapter;
import com.martiproduction.drinkownia.R;

import java.util.ArrayList;
import java.util.List;


public class RecipesList extends Fragment implements RecipesListAdapter.OnClickListener {


    private View parentView;
    private RecyclerView recyclerView;
    private List<RecipeInfo> recipeInfo;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_recipes_list,container,false);

        recipeInfo = new ArrayList<>();

        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Sex on the beach",2));
        recipeInfo.add(new RecipeInfo("http://www.robdrinki.pl/wordpress/wp-content/uploads/2012/10/tropical-hooter1.jpg","Choco Loco",3));



        recyclerView = (RecyclerView) parentView.findViewById(R.id.recyclerview_list);

       // recyclerView.hasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        RecipesListAdapter recipesListAdapter = new RecipesListAdapter(recipeInfo,recyclerView);
        recipesListAdapter.setOnClickListener(this);

        recyclerView.setAdapter(recipesListAdapter);


        return parentView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



    @Override
    public void clickedFavButton(int position) {

    }

    @Override
    public void clickedRecipe(int position) {
        getFragmentManager().beginTransaction().remove(this).commit();
        Intent showDetailsActivity = new Intent(getActivity(), RecipeDetails.class);
        showDetailsActivity.putExtra("RecipeInfo",recipeInfo.get(position));
        startActivity(showDetailsActivity);
        getActivity().finish();
    }
}
