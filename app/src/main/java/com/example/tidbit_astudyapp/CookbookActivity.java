package com.example.tidbit_astudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Vector;

public class CookbookActivity extends AppCompatActivity {

    private ShelfActivity shelfActivity;
//    private Vector<TextView> foodInfoTextViewList = new Vector<TextView>(shelfActivity.getFoodsList().size());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookbook);

//        int timeCount = 0;
//        for(int i = 0; i <= shelfActivity.getFoodsList().size(); i++) {
//            TextView tempFoodInfo = findViewById(R.id.);
//            foodInfoTextViewList.add(tempFoodInfo);
//        }

    }
    public void onBackPressed(View view) {
        Log.d("Example: ", "Clicked back");
        finish();
    }
}