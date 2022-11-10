package com.mishura.service;

import com.mishura.model.Car;

import java.util.Random;

public class CarService {
    public Car create(){
        return new Car(randomString(9), randomString(7), randomString(8));
    }

    public void print(Car car){
        System.out.printf("{Manufacture: %s\tEngine: %s\tColor: %s\tCount %d\tPrice: %d}%n",
                car.getManufacturer(),
                car.getEngine(),
                car.getColor(),
                car.getCount(),
                car.getPrice());
    }

    private static String randomString(int length){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
             int number = random.nextInt(chars.length());
             char ch = chars.charAt(number);
             builder.append(ch);
        }
        return builder.toString();
    }
}
