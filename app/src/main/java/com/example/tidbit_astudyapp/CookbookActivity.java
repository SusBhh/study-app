package com.example.tidbit_astudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class CookbookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookbook);
    }
    public void onBackPressed(View view) {
        Log.d("Example: ", "Clicked back");
        finish();
    }
}