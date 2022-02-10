package com.example.balloon;

import java.util.Random;

public class NumberClass {
    private int numberOne;
    private int numberTwo;
    private int correctAnswer;
    private int randomNumber1;
    private int randomNumber2;
    private int randomNumber3;


    public NumberClass() {
        Random random = new Random();
        numberOne = random.nextInt(50);
        numberTwo = random.nextInt(50);
        correctAnswer = numberOne + numberTwo;
        randomNumber1 = random.nextInt(100);
        randomNumber2 = random.nextInt(100);
        randomNumber3 = random.nextInt(100);
    }

    public int getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(int numberOne) {
        this.numberOne = numberOne;
    }

    public int getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(int numberTwo) {
        this.numberTwo = numberTwo;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getRandomNumber1() {
        return randomNumber1;
    }

    public void setRandomNumber1(int randomNumber1) {
        this.randomNumber1 = randomNumber1;
    }

    public int getRandomNumber2() {
        return randomNumber2;
    }

    public void setRandomNumber2(int randomNumber2) {
        this.randomNumber2 = randomNumber2;
    }

    public int getRandomNumber3() {
        return randomNumber3;
    }

    public void setRandomNumber3(int randomNumber3) {
        this.randomNumber3 = randomNumber3;
    }
}

