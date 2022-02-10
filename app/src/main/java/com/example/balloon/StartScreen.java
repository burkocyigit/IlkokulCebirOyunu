package com.example.balloon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }

    public void startRestart(View view) {
        Intent intent = new Intent(StartScreen.this, MainActivity.class);
        finish();
        startActivity(intent);
    }
}