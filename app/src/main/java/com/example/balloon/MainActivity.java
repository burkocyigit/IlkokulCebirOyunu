package com.example.balloon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;


import com.example.balloon.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    NumberClass numberClass;
    Random random = new Random();
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.score.setText("Skor : 0");
        new CountDownTimer(61000, 1000) {

            @Override
            public void onTick(long l) {
                binding.timer.setText(Long.toString(l/1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, FinishScreen.class);
                finish();
                intent.putExtra("score", score);
                startActivity(intent);
            }
        }.start();
        createNumbers();
    }

    public void createNumbers() {
        numberClass = new NumberClass();
        int r = random.nextInt(4);
        binding.operation.setText(numberClass.getNumberOne() + " + " + numberClass.getNumberTwo());
        binding.balon.setText(Integer.toString(numberClass.getRandomNumber1()));
        binding.balon1.setText(Integer.toString(numberClass.getRandomNumber2()));
        binding.balon2.setText(Integer.toString(numberClass.getRandomNumber3()));

        if (r == 0)
            binding.balon.setText(Integer.toString(numberClass.getCorrectAnswer()));
        else if (r == 1)
            binding.balon1.setText(Integer.toString(numberClass.getCorrectAnswer()));
        else if (r == 2)
            binding.balon2.setText(Integer.toString(numberClass.getCorrectAnswer()));
        else
            binding.balon3.setText(Integer.toString(numberClass.getCorrectAnswer()));
    }


    public void blow(View view) {
        TextView textView = view.findViewById(view.getId());

        if (textView.getText().toString().equals(Integer.toString(numberClass.getCorrectAnswer()))) {
            new CountDownTimer(200, 200) {
                public void onFinish() {
                    binding.operation.setBackgroundColor(255);
                }

                public void onTick(long millisUntilFinished) {
                    binding.operation.setBackgroundColor(Color.parseColor("#28ed28")); //GREEN

                }
            }.start();
            score++;
        } else {
            new CountDownTimer(200, 200) {
                public void onFinish() {
                    binding.operation.setBackgroundColor(255);
                }

                public void onTick(long millisUntilFinished) {
                    binding.operation.setBackgroundColor(Color.parseColor("#bf0b0b")); //RED
                }
            }.start();
            score--;
        }
        binding.score.setText("Skor : " + score);
        createNumbers();
    }
}
