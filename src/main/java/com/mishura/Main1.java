package com.mishura;

public class Main1 {
    //Задано довжини трьох сторін трикутника - знайти його площу.
    public static void main(String[] args) {
        System.out.println(areaOfTriangle(-3, 4, 5));
        System.out.println(areaOfTriangle(3, 0, 5));
        System.out.println(areaOfTriangle(3, 3, 7));
        System.out.println(areaOfTriangle(3, 5, 8));

        System.out.println(areaOfTriangle(3, 4, 5));
        System.out.println(areaOfTriangle(7, 8, 9));
        System.out.println(areaOfTriangle(2, 4, 3));
        System.out.println(areaOfTriangle(4, 6, 7));
    }

    public static double areaOfTriangle(int a, int b, int c){
        double s = 0;
        if((a <= 0) || (b <= 0) || (c <= 0)){
            return s;
        }

        if((a + b <= c) || (a + c <= b)|| (c + b <= a)){
            return s;
        }
        double p = (a + b + c)/2.0;
        s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return s;
    }
}
