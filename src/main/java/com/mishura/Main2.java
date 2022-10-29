package com.mishura;

public class Main2 {
    //Згенерувати три випадкових числа і знайти найменше за модулем, використовуючи тернарний оператор.
    public static void main(String[] args) {
        int a = randomNumber(-1000, 1000);
        int b = randomNumber(-1000, 1000);
        int c = randomNumber(-1000, 1000);
        minABS(a, b, c);
    }
    public static int randomNumber(int min, int max){
        int number = (int) ((Math.random()*(max - min)) + min);
        return number;
    }

    public static void minABS(int a, int b, int c){
        int minAB = Math.abs(a) < Math.abs(b) ? Math.abs(a) : Math.abs(b);
        int minABC = Math.abs(minAB) < Math.abs(c) ? Math.abs(minAB) : Math.abs(c);
        System.out.println(a + " " + b + " " + c);
        System.out.println("Найменше за модулем - " + minABC + ".");
    }
}
