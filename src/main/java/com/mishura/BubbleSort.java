package com.mishura;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
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

    private static void bubbleSort(){
        int[] numbers = createArray(10, 0, 100);
        for (int j = 0; j < numbers.length-1; j++) {
            boolean isChanged = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                    if (!isChanged){
                        isChanged = true; }
                }
            }
            System.out.println(Arrays.toString(numbers));
            if(!isChanged){
                break;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}

