package com.example.balloon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class StartScreen extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    private int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        radioGroup = findViewById(R.id.radioGroup2);
    }

    public void startRestart(View view) {
        Intent intent = new Intent(StartScreen.this, MainActivity.class);
        intent.putExtra("level", level);
        finish();
        startActivity(intent);
    }

    public void adjLevel(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        if (radioButton.getText().toString().equals("Zor"))
            level = 1;
        else
            level = 0;
    }
}