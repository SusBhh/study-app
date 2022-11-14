package com.example.tidbit_astudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

// Basically Main activity
public class ShelfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelf);
    }

    public void onTimerPressed(View view) {
        Intent myIntent = new Intent(getBaseContext(), TimerActivity.class);
        startActivity(myIntent);
    }
    public void onCookbookPressed(View view) {
        Intent myIntent = new Intent(getBaseContext(), CookbookActivity.class);
        startActivity(myIntent);
    }
    public void onShoppingListPressed(View view) {
        Intent myIntent = new Intent(getBaseContext(), ShoppingListActivity.class);
        startActivity(myIntent);
    }
    public void onProfilePressed(View view) {
        Intent myIntent = new Intent(getBaseContext(), ProfileActivity.class);
        startActivity(myIntent);
    }
}