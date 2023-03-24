package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private long holdoffset;
    private boolean running;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
    }

    public void startchronometer(View v){
        if (!running){
            chronometer.setBase(SystemClock.elapsedRealtime() - holdoffset);
            chronometer.start();
            running = true ;
        }
    }
    public void holdchronometer(View v){
        if (running){
            chronometer.stop();
            holdoffset = SystemClock.elapsedRealtime()- chronometer.getBase();
            running = false;
        }
    }
    public void stopchronometer(View v){
        chronometer.setBase(SystemClock.elapsedRealtime());
        holdoffset=0;
    }
}