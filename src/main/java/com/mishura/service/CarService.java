package com.mishura.service;

import com.mishura.model.Car;
import com.mishura.model.Color;
import com.mishura.model.Engine;

import java.util.Random;

public class CarService {
    public Car create() {
        final String manufacturer = randomString(9);
        final Random random = new Random();
        final Color[] colors = Color.values();
        final Color color = colors[random.nextInt(colors.length)];
        final Engine engine = new Engine(random.nextInt(1000), randomString(7));
        return new Car(manufacturer, engine, color);
    }

    public void print(Car car) {
        System.out.printf("{Manufacture: %-12s\tEngine: %12s\tColor: %-8s\tCount %-4d\tPrice: %d}%n",
                car.getManufacturer(),
                car.getEngine(),
                car.getColor(),
                car.getCount(),
                car.getPrice());
    }

    private String randomString(int length) {
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

    public void check(Car car) {
        if (car.getCount() < 1) {
            System.out.println("Машини нема в наявності.");
            return;
        } else if (car.getEngine().getPower() < 200) {
            System.out.println("Потужність двигуна менше 200.");
            return;
        }
        System.out.println("Машина повністю готова до продажу.");
    }
}