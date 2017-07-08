package com.martiproduction.drinkownia.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.martiproduction.drinkownia.R;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        findViewById(R.id.loginButton).setOnClickListener(v -> startActivity(new Intent(this,Login.class)));
        findViewById(R.id.registerButton).setOnClickListener(v -> startActivity(new Intent(this,Registration.class)));
    }
}
