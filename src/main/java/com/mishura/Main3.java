package com.mishura;

public class Main3 {
    public static void main(String[] args) {
        isEven(randomNumber(-1000,10000));
        isEven(randomNumber(-100,100));
    }

    public static int randomNumber(int min, int max){
        int number = (int) ((Math.random()*(max - min)) + min);
        return number;
    }

    public static void isEven(int number){
        if (number % 2 == 0){
            System.out.println(number + " - парне число.");
        } else {
            System.out.println(number + " - непарне число.");
        }
    }
}
