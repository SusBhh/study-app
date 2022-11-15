package com.example.tidbit_astudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void onLoginPressed(View view) {
        Intent myIntent = new Intent(getBaseContext(), ShelfActivity.class);
        startActivity(myIntent);
    }
}