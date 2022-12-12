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
    public static Vector<FoodItem> FoodsList = new Vector<FoodItem>(15);

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
}