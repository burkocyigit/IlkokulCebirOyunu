package com.example.balloon;

import java.util.Random;

public class NumberClass {
    private int numberOne;
    private int numberTwo;
    private int correctAnswer;
    private int randomNumber1;
    private int randomNumber2;
    private int randomNumber3;
    private int operation;


    public NumberClass(int level) {
        Random random = new Random();
        operation = random.nextInt(3);
        if (operation == 2 && level == 0) {
            numberOne = random.nextInt(10) + 1;
            numberTwo = random.nextInt(10) + 1;
        } else if (operation == 2 && level == 1) {
            numberOne = random.nextInt(15) + 1;
            numberTwo = random.nextInt(15) + 1;
        } else if (operation == 1) {
            int n = 50;
            if (level == 1)
                n = 100;
            while (true) {
                numberOne = random.nextInt(n) + 1;
                numberTwo = random.nextInt(n) + 1;
                if (numberOne > numberTwo)
                    break;
            }
        } else {
            int n=50;
            if (level == 1) {
                n = 100;
            }
            numberOne = random.nextInt(n) + 2;
            numberTwo = random.nextInt(n) + 1;
        }

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

    public int getCorrectAnswer(int n) {
        if (n == 0)
            return numberOne + numberTwo;
        if (n == 1)
            return Math.max(numberOne, numberTwo) - Math.min(numberOne, numberTwo);
        else
            return numberTwo * numberOne;
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

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public int getRandomNumber3() {
        return randomNumber3;
    }

    public void setRandomNumber3(int randomNumber3) {
        this.randomNumber3 = randomNumber3;
    }
}

