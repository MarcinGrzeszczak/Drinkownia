package com.martiproduction.drinkownia.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.martiproduction.drinkownia.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Marcin on 02.03.2017.
 */

public class RecipeDetailsGlassType extends Fragment {

    @BindView(R.id.glasstype_text)
    TextView glassTypeText;

    @BindView(R.id.glasstype_image)
    ImageView glassTypeImage;


    private Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_glass_type,container,false);

        unbinder = ButterKnife.bind(this, view);

        glassTypeText.setText("Koktajl");

        glassTypeImage.setImageResource(R.drawable.coctail_glass);

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
