package com.martiproduction.drinkownia.Fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.martiproduction.drinkownia.R;

import org.apmem.tools.layouts.FlowLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class RecipeDetailsTags extends Fragment {


    @BindView(R.id.fragment_tags_root_view)
    FlowLayout layout;



    private Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tags,container,false);
        unbinder = ButterKnife.bind(this,view);

        final float scale =  getActivity().getApplicationContext().getResources().getDisplayMetrics().density;

        final int pixels_10 = (int) (10 * scale + 0.5f);
        final int pixels_5 = (int) (5 * scale + 0.5f);

        for(int i  = 0 ; i<10;i++) {

            TextView tag = new TextView(getActivity());
            tag.setPadding(pixels_10,pixels_10,pixels_10,pixels_10);

            tag.setBackgroundResource(R.drawable.tag);

            tag.setTextColor(Color.WHITE);
            tag.setText("Koktajl");
            layout.addView(tag);

            FlowLayout.LayoutParams llp = (FlowLayout.LayoutParams) tag.getLayoutParams();
            llp.setMargins(pixels_5,pixels_5, pixels_5, pixels_5); // llp.setMargins(left, top, right, bottom);
            tag.setLayoutParams(llp);




        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
