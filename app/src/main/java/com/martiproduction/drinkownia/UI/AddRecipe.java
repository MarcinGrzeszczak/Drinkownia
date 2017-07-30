package com.martiproduction.drinkownia.UI;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.martiproduction.drinkownia.Fragments.AddRecipePicture;
import com.martiproduction.drinkownia.Fragments.TakePicture;
import com.martiproduction.drinkownia.R;

public class AddRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        TakePicture takePicture = new TakePicture();
        getFragmentManager().beginTransaction().add(R.id.addRecipe_fragment_container,takePicture).commit();
    }
}
