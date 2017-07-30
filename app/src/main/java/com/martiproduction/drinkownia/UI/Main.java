package com.martiproduction.drinkownia.UI;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.martiproduction.drinkownia.CustomViews.NavigationDrawerHeaderMain;
import com.martiproduction.drinkownia.Fragments.RecipesList;
import com.martiproduction.drinkownia.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Main extends AppCompatActivity implements DrawerLayout.DrawerListener {

    @BindView(R.id.main_toolbar)
        Toolbar toolbar;


    @BindView(R.id.main_drawerLayout)
        DrawerLayout drawerLayout;

    @BindView(R.id.main_drawerLayout_navigationView)
    NavigationView navigationView;

    private NavigationDrawerHeaderMain header;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_main_drawer, R.string.close_main_drawer);
        drawerLayout.addDrawerListener(this);
        drawerToggle.syncState();

        header = new NavigationDrawerHeaderMain(this);

        navigationView.addHeaderView(header);
        navigationView.setNavigationItemSelectedListener(onNavigationItemSelectedListener);

        header.setPause(true);

        getFragmentManager().beginTransaction().add(R.id.main_listFragment,new RecipesList()).commit();
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

        if(slideOffset < 1.0)
            header.setPause(true);
        else
            header.setPause(false);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
      //  header.setPause(false);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
      //  header.setPause(true);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
     //   header.setPause(true);
    }

    NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){
                case R.id.main_drawer_addNewDrink:
                    startActivity(new Intent(Main.this,AddRecipe.class));
            }
            return true;
        }
    };
}
