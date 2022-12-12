package com.example.tidbit_astudyapp;


import android.content.Context;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class FoodItem extends AppCompatActivity {
    private static Context context;

    public FoodItem(Context context) {this.context = context;};

    private int foodID;
    private String timeTextID;
    private int quantity;
    private int time;
    private TextView timeText;
    private TextView quantityText;

    public FoodItem(int foodID, int time) {
        this.foodID = foodID;
        this.timeTextID = "st" + Integer.toString(foodID);
        this.quantity = 0;
        this.time = time;
        this.timeText = findViewById(R.id.timeTextID);

    }

    public int getFoodID() {return this.foodID;}
    public void setFoodID(String newFoodID) {this.name = newFoodID;}
    public String getName() {return this.name;}
    public void setName(String newName) {this.name = newName;}
    public int getQuantity() {return this.quantity;}
    public void setQuantity(int newQuantity) {this.quantity = newQuantity;}
    public int getTime() {return this.time;}
    public void setTime(int newTime) {this.time = newTime;}

}

