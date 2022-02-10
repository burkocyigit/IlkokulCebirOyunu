package com.example.balloon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinishScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_screen);
        Intent intent = getIntent();
        TextView textView = findViewById(R.id.finishScore);
        int score = intent.getIntExtra("score", 31);
        textView.setText("Skorun : " + score);
    }

    public void startAgain(View view) {
        Intent intent = new Intent(FinishScreen.this, MainActivity.class);
        finish();
        startActivity(intent);
    }
}