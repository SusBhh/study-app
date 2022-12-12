package com.example.tidbit_astudyapp;


import android.content.Context;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class FoodItem {
    private static Context context;

    public FoodItem(Context context) {this.context = context;};

    private int foodID;
    private String name;
    private int quantity;
    private int time;
//    private TextView quantityText;

    public FoodItem(int foodID, int time) {
        this.foodID = foodID;
        //this.quantityTextID = "sq" + Integer.toString(foodID);
        this.quantity = 0;
        this.time = time;
        //this.quantityText = findViewById(R.id.quantityTextID);
//        if(foodID == 0){this.quantityText = findViewById(R.id.sq0);}
//        else if(foodID == 1){this.quantityText = findViewById(R.id.sq1);}
//        else if(foodID == 2){this.quantityText = findViewById(R.id.sq2);}
//        else if(foodID == 3){this.quantityText = findViewById(R.id.sq3);}
//        else if(foodID == 4){this.quantityText = findViewById(R.id.sq4);}
//        else if(foodID == 5){this.quantityText = findViewById(R.id.sq5);}
//        else if(foodID == 6){this.quantityText = findViewById(R.id.sq6);}
//        else if(foodID == 7){this.quantityText = findViewById(R.id.sq7);}
//        else if(foodID == 8){this.quantityText = findViewById(R.id.sq8);}
//        else if(foodID == 9){this.quantityText = findViewById(R.id.sq9);}
//        else if(foodID == 10){this.quantityText = findViewById(R.id.sq10);}
//        else if(foodID == 11){this.quantityText = findViewById(R.id.sq11);}
//        else if(foodID == 12){this.quantityText = findViewById(R.id.sq12);}
//        else if(foodID == 13){this.quantityText = findViewById(R.id.sq13);}

    }

    public int getFoodID() {return this.foodID;}
    public void setFoodID(String newFoodID) {this.name = newFoodID;}
    public String getName() {return this.name;}
    public void setName(String newName) {this.name = newName;}
    public int getQuantity() {return this.quantity;}
    public void setQuantity(int newQuantity) {this.quantity = newQuantity;}
    public int getTime() {return this.time;}
    public void setTime(int newTime) {this.time = newTime;}
//    public void setQuantityText() {this.quantityText.setText(Integer.toString(this.quantity));}

}

