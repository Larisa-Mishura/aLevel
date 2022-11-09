package com.mishura;

import com.mishura.model.Car;
import com.mishura.service.CarService;

public class Main {

    public static void main(String[] args) {
        final CarService carService = new CarService();

        final Car testCar = new Car("manufacture", "engine", "color");
        carService.print(testCar);

        final Car car1 = carService.create();
        carService.print(car1);

        final Car car2 = carService.create();
        carService.print(car2);

        final Car car3 = carService.create();
        carService.print(car3);
    }
}
