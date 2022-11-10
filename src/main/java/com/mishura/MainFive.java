package com.mishura;

import java.util.Arrays;
import java.util.Random;

public class MainFive {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        bubbleSort();
    }

    public static int[] createArray(int size, int min, int max){
        int[] array = new int[size];
        Random random = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = random.nextInt(max - min +1) + min;
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    public static void task1(){
        int[] array = createArray(12, -15, 15);
        int index = 0;
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            if (array[i] >= max) {
                max = array[i];
                index = i;
            }
        }
        System.out.println(index);
    }

    public static void task2(){
        int[] array = createArray(8, 1, 10);
        for(int i = 1; i < array.length; i+=2) {
            array[i] = 0;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void task3(){
        int[] array = createArray(4, 10, 99);
        for(int i = 0; i < array.length-1; i++) {
            if (array[i+1] <= array[i]) {
                System.out.println("Масив не є строго зростаючою послідовністю.");
                return;
            }
        }
        System.out.println("Масив - строго зростаюча послідовність.");
    }

    public static void task4(){
        int[] array1 = createArray(5, 0, 5);
        double s1 = arithmeticMean(array1);
        //System.out.println(s1);

        int[] array2 = createArray(5, 0, 5);
        double s2 = arithmeticMean(array2);
        //System.out.println(s2);

        if (s1 > s2){
            System.out.println("Середнє аріфметичне елементів першого масиву більше.");
        } else if (s1 < s2){
            System.out.println("Середнє аріфметичне елементів другого масиву більше.");
        } else {
            System.out.println("Середнє аріфметичне елементів першого масиву та середнє аріфметичне елементів другого масиву рівні.");
        }
    }

    public static double arithmeticMean(int[] array){
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum * 1.0 / array.length;
    }

    private static void bubbleSort(){
        int[] numbers = createArray(10, 0, 100);
        for (int j = 0; j < numbers.length-1; j++) {
            boolean isChanged = false;
            for (int i = 0; i < numbers.length - j - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                    if (!isChanged){
                        isChanged = true; }
                }
            }
            if(!isChanged){
                break;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }

}
