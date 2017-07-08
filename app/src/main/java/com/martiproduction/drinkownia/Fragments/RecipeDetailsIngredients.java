package com.martiproduction.drinkownia.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.martiproduction.drinkownia.CustomViews.IngredientListAdapter;
import com.martiproduction.drinkownia.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Marcin on 25.02.2017.
 */

public class RecipeDetailsIngredients extends Fragment{


    @BindView(R.id.ingredients_list)
    RecyclerView ingredientsList;

    private Unbinder unbinder;
    private List<String> ingredients;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ingredients = new ArrayList<>();

        ingredients.add("Wódka");
        ingredients.add("Shnapps brzoskwiniowy");
        ingredients.add("Sok pomarańczowy");
        ingredients.add("Sok żurawinowy");
        ingredients.add("Lód");


        View view = inflater.inflate(R.layout.fragment_ingredients,container,false);

        unbinder = ButterKnife.bind(this,view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        IngredientListAdapter ingredientListAdapter = new IngredientListAdapter(ingredients);

        ingredientsList.setLayoutManager(layoutManager);
        ingredientsList.setAdapter(ingredientListAdapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
