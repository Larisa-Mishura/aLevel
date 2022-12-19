package com.mishura.util;

import com.mishura.model.Car;
import com.mishura.model.Truck;

import java.util.Arrays;

public class AlgorithmUtil {

    public static int compareCars(final Car first, final Car second){//положительное, если first > second;
        return first.getId().compareTo(second.getId());
    }

    public static void bubbleSort(Car[] cars){
        for (int j = 0; j < cars.length-1; j++) {
            boolean isChanged = false;
            for (int i = 0; i < cars.length - j - 1; i++) {
                if (compareCars(cars[i], cars[i + 1]) > 0) {
                    Car temp = cars[i];
                    cars[i] = cars[i + 1];
                    cars[i + 1] = temp;
                    if (!isChanged){
                        isChanged = true; }
                }
            }
            if(!isChanged){
                break;
            }
        }
        System.out.println(Arrays.toString(cars));
    }

    public static int binarySearch(Car cars[], Car carToSearch) {
        bubbleSort(cars);
        int firstIndex = 0;
        int lastIndex = cars.length - 1;

        //
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if ( compareCars(cars[middleIndex], carToSearch) == 0 ){
                return middleIndex;
            } else if ( compareCars(cars[middleIndex], carToSearch) < 0 ) {
                firstIndex = middleIndex + 1;
            }  else if ( compareCars(cars[middleIndex], carToSearch) > 0 ) {
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }
}
