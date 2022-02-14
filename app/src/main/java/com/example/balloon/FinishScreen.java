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
        TextView cevaplanan = findViewById(R.id.cevaplanan);
        TextView dogru = findViewById(R.id.dogru);
        TextView yanlis = findViewById(R.id.yanlis);
        int cevaplananSayisi = intent.getIntExtra("question", 0);
        int dogruSayisi = intent.getIntExtra("correct", 0);
        int yanlisSayisi = cevaplananSayisi - dogruSayisi;
        int score = intent.getIntExtra("score", 31);
        cevaplanan.setText("Cevaplanan : " + cevaplananSayisi);
        dogru.setText("Doğru : " + dogruSayisi);
        yanlis.setText("Yanlış : " + yanlisSayisi);
        textView.setText("Skorun : " + score);
    }

    public void startAgain(View view) {
        Intent intent = new Intent(FinishScreen.this, MainActivity.class);
        finish();
        startActivity(intent);
    }
}