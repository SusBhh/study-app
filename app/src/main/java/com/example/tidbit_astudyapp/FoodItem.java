package com.example.tidbit_astudyapp;


import android.content.Context;

public class FoodItem {
    private static Context context;

    public FoodItem(Context context) {this.context = context;};

    private String foodID;
    private String name;
    private int quantity;
    private int time;

    public FoodItem(String foodID, int time) {
        this.foodID = foodID;
        this.name = "";
        this.quantity = 0;
        this.time = time;
    }

    public String getFoodID() {return this.foodID;}
    public void setFoodID(String newFoodID) {this.name = newFoodID;}
    public String getName() {return this.name;}
    public void setName(String newName) {this.name = newName;}
    public int getQuantity() {return this.quantity;}
    public void setQuantity(int newQuantity) {this.quantity = newQuantity;}
    public int getTime() {return this.time;}
    public void setTime(int newTime) {this.time = newTime;}

}

