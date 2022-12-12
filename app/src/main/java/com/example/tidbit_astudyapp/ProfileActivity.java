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
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class ProfileActivity extends AppCompatActivity {

    // Shared preferences
    public SavedInformation savedInformation;
    private SeekBar seekBar;
    private float lightThreshold;
    private TextView textView;
    private EditText editText;

    // Sensor variables
    private SensorManager sensorManager;
    private Sensor sensorLight;

    // Google Sign Out
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    TextView name,email;
    Button signOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Create and get shared preferences
        savedInformation = new SavedInformation(this);
        seekBar = (SeekBar)findViewById(R.id.light_threshold_seekbar);
        textView = (TextView)findViewById(R.id.light_threshold_text);

        lightThreshold = savedInformation.getFloat("lightThreshold");
        seekBar.setProgress((int)savedInformation.getFloat("lightThreshold"));
        textView.setText("Set night mode when below " + (int)lightThreshold + " lumens.");

        // Create sensor
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        // Listeners
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                savedInformation.setFloat("lightThreshold", progress);

                lightThreshold = savedInformation.getFloat("lightThreshold");
                seekBar.setProgress((int)savedInformation.getFloat("lightThreshold"));
                textView.setText("Set night mode when below " + (int)lightThreshold + " lumens.");

                changeDayNightTheme(savedInformation.getFloat("lightSensorValue"), lightThreshold);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        SensorEventListener sensorEventListenerLight = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float lightSensorValue = sensorEvent.values[0];
                savedInformation.setFloat("lightSensorValue", lightSensorValue);
                changeDayNightTheme(savedInformation.getFloat("lightSensorValue"), lightThreshold);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };

        sensorManager.registerListener(sensorEventListenerLight, sensorLight, SensorManager.SENSOR_DELAY_NORMAL);

        // Profile Info and Sign Out
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        signOutBtn = findViewById(R.id.signout);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            name.setText(personName);
            email.setText(personEmail);
        }

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

    }

    public void onColorChangeClick(View view) {
        String colorString = String.valueOf(editText.getText());
        savedInformation.setStr("keyColor", colorString);
        Log.d("Example: ", savedInformation.getStr("keyColor"));
    }

    private void changeDayNightTheme(float lightSensorValue, float lightThreshold) {
        if (lightSensorValue < lightThreshold) {
            Log.d("Example:", "onSensorChanged: it is dark");
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else {
            Log.d("Example:", "onSensorChanged: it is light");
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    void signOut(){
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                finish();
                startActivity(new Intent(ProfileActivity.this,LoginActivity.class));
            }
        });
    }

    public void onBackPressed(View view) {
        Log.d("Example: ", "Clicked back");
        finish();
    }
}