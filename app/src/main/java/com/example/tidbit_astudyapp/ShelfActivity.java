package com.example.tidbit_astudyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Vector;

// Basically Main activity
public class ShelfActivity extends AppCompatActivity {

    // Shared preferences variables
    public SavedInformation savedInformation;
    private float lightThreshold = 5000;

    // Sensor variables
    private SensorManager sensorManager;
    private Sensor sensorLight;

    // Foods array
    public static Vector<FoodItem> FoodsList = new Vector<FoodItem>(14);

    public static Vector<TextView> foodQuanText = new Vector<TextView>(14);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelf);


        // Get shared preferences
        savedInformation = new SavedInformation(this);
        lightThreshold = savedInformation.getFloat("lightThreshold");

        // Create sensor
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        SensorEventListener sensorEventListenerLight = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float floatSensorValue = sensorEvent.values[0];
                changeDayNightTheme(floatSensorValue, lightThreshold);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        sensorManager.registerListener(sensorEventListenerLight, sensorLight, SensorManager.SENSOR_DELAY_NORMAL);

        // Create Foods List
        int timeCount = 0;
        for(int i = 0; i <= 13; i++) {
            //String tempFoodId = "f" + Integer.toString(i);
            if(i == 2) {timeCount += 5;}
            else if(i % 3 == 0) {timeCount += 15;}
            FoodItem tempFoodItem = new FoodItem(i, timeCount);
            FoodsList.add(tempFoodItem);
        }

        // Create foodQuanText List
        TextView tempTextView = findViewById(R.id.sq0);
        for (int i = 0; i < 14; i++) {
            foodQuanText.add(tempTextView);
            if(i == 0)
                foodQuanText.set(0, findViewById(R.id.sq0));
            else if (i == 1)
                foodQuanText.set(1, findViewById(R.id.sq1));
            else if (i == 2)
            foodQuanText.set(2, findViewById(R.id.sq2));
            else if (i == 3)
            foodQuanText.set(3, findViewById(R.id.sq3));
            else if (i == 4)
            foodQuanText.set(4, findViewById(R.id.sq4));
            else if (i == 5)
            foodQuanText.set(5, findViewById(R.id.sq5));
            else if (i == 6)
            foodQuanText.set(6, findViewById(R.id.sq6));
            else if (i == 7)
            foodQuanText.set(7, findViewById(R.id.sq7));
            else if (i == 8)
            foodQuanText.set(8, findViewById(R.id.sq8));
            else if (i == 9)
            foodQuanText.set(9, findViewById(R.id.sq9));
            else if (i == 10)
            foodQuanText.set(10, findViewById(R.id.sq10));
            else if (i == 11)
            foodQuanText.set(11, findViewById(R.id.sq11));
            else if (i == 12)
            foodQuanText.set(12, findViewById(R.id.sq12));
            else if (i == 13)
            foodQuanText.set(13, findViewById(R.id.sq13));
        }

    }

    private void changeDayNightTheme(float floatSensorValue, float lightThreshold) {
        if (floatSensorValue < lightThreshold) {
            Log.d("Example:", "onSensorChanged: it is dark");
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else {
            Log.d("Example:", "onSensorChanged: it is light, "+ floatSensorValue + " " + lightThreshold);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
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

    public Vector<FoodItem> getFoodsList() {
        return this.FoodsList;
    }
}