package com.martiproduction.drinkownia.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.martiproduction.drinkownia.CustomViews.CustomEditText;
import com.martiproduction.drinkownia.R;

public class Login extends AppCompatActivity {

    private CustomEditText loginField,  passwordField;
    private RelativeLayout helloText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginField = (CustomEditText) findViewById(R.id.Login_LoginField);
        passwordField = (CustomEditText) findViewById(R.id.Login_PasswordField);
        helloText = (RelativeLayout) findViewById(R.id.HelloTextLayout);

        loginField.setSoftKeyboardListener(this::animateFadingHelloText);
        passwordField.setSoftKeyboardListener(this::animateFadingHelloText);

        findViewById(R.id.Login_LoginButton).setOnClickListener(v->startActivity(new Intent(this,Main.class)));
    }

    private void animateFadingHelloText(boolean show){
        if(show)
            helloText.animate().alpha(0.0f);
        else
            helloText.animate().alpha(1.0f);
    }
}
