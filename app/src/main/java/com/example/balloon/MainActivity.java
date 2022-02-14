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
    int score = 0;
    int level=0;
    int question = 0;
    int correct = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        level = intent.getIntExtra("level", 0);
        binding.score.setText("Skor : 0");
        new CountDownTimer(61000, 1000) {

            @Override
            public void onTick(long l) {
                binding.timer.setText(Long.toString(l / 1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, FinishScreen.class);
                finish();
                intent.putExtra("score", score);
                intent.putExtra("question", question);
                intent.putExtra("correct", correct);
                startActivity(intent);
            }
        }.start();
        createNumbers();
    }

    public void createNumbers() {
        numberClass = new NumberClass(level);
        int r = random.nextInt(4);
        String str = Integer.toString(numberClass.getNumberOne());
        if (numberClass.getOperation() == 0)
            str = str.concat(" + " + numberClass.getNumberTwo());
        if (numberClass.getOperation() == 1)
            str = str.concat(" - " + numberClass.getNumberTwo());
        if (numberClass.getOperation() == 2)
            str = str.concat(" x " + numberClass.getNumberTwo());
        binding.operation.setText(str);
        binding.balon.setText(Integer.toString(numberClass.getRandomNumber1()));
        binding.balon1.setText(Integer.toString(numberClass.getRandomNumber2()));
        binding.balon2.setText(Integer.toString(numberClass.getRandomNumber3()));

        if (r == 0)
            binding.balon.setText(Integer.toString(numberClass.getCorrectAnswer(numberClass.getOperation())));
        else if (r == 1)
            binding.balon1.setText(Integer.toString(numberClass.getCorrectAnswer(numberClass.getOperation())));
        else if (r == 2)
            binding.balon2.setText(Integer.toString(numberClass.getCorrectAnswer(numberClass.getOperation())));
        else
            binding.balon3.setText(Integer.toString(numberClass.getCorrectAnswer(numberClass.getOperation())));
    }


    public void blow(View view) {
        TextView textView = view.findViewById(view.getId());

        if (textView.getText().toString().equals(Integer.toString(numberClass.getCorrectAnswer(numberClass.getOperation())))) {
            new CountDownTimer(200, 200) {
                public void onFinish() {
                    binding.operation.setBackgroundColor(255);
                }

                public void onTick(long millisUntilFinished) {
                    binding.operation.setBackgroundColor(Color.parseColor("#28ed28")); //GREEN

                }
            }.start();
            score++;
            correct++;
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
        question++;
    }
}