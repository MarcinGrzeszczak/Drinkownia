package com.martiproduction.drinkownia.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.martiproduction.drinkownia.CustomViews.DirectionsListAdapter;
import com.martiproduction.drinkownia.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Marcin on 25.02.2017.
 */

public class RecipeDetailsDirections extends Fragment {

    @BindView(R.id.directions_list)
    RecyclerView list;


    private Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_directions,container,false);

        List<String> test = new ArrayList<>();

        test.add("Wszystkie składniki, poza sokiem żurawinowym, wlewamy do shakera.");
        test.add("Wstrząsamy,");
        test.add("Szklankę wypełniamy do połowy lodem.");
        test.add("Przelewamy zawartość shakera do szklanki.");
        test.add("Dolewamy soku żurawinowego.");
        test.add("Ozdabiamy kawałkiem pomarańczy");

        unbinder = ButterKnife.bind(this,view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        DirectionsListAdapter directionAdapter = new DirectionsListAdapter(test);

        list.setLayoutManager(layoutManager);
        list.setAdapter(directionAdapter);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
