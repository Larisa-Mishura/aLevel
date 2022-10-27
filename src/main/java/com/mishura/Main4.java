package com.mishura;

public class Main4 {
    //Написати метод який переводить число з 10 системи числення в двійкову. Число положительное
    public static void main(String[] args) {
        System.out.println(toBinarySystem(1));
        System.out.println(toBinarySystem2(1));

        System.out.println(toBinarySystem(Integer.MAX_VALUE));
        System.out.println(toBinarySystem2(Integer.MAX_VALUE));

        System.out.println(toBinarySystem(Integer.MIN_VALUE));
        System.out.println(toBinarySystem2(Integer.MIN_VALUE));

        System.out.println(toBinarySystem(19));
        System.out.println(toBinarySystem2(19));

        System.out.println(toBinarySystem(256));
        System.out.println(toBinarySystem2(256));

    }

    public static String toBinarySystem(int number) {
        return Integer.toBinaryString(number);
    }

    public static String toBinarySystem2(int number) {
        if (number <= 0) {
            return "Очікується додатне число";
        }
        String s = "";
        while (number > 0) {
            s = s + (number % 2);
            number = number / 2;
        }
        return new StringBuilder(s).reverse().toString();
    }
}



