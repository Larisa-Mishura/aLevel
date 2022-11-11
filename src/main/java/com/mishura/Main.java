package com.mishura;

import com.mishura.model.Car;
import com.mishura.service.CarService;

public class Main {

    public static void main(String[] args) {
        final CarService carService = new CarService();

        final Car testCar = carService.create();
        testCar.setCount(0);
        carService.print(testCar);
        carService.check(testCar);

        final Car car1 = carService.create();
        carService.print(car1);
        carService.check(car1);

        final Car car2 = carService.create();
        carService.print(car2);
        carService.check(car2);

        final Car car3 = carService.create();
        carService.print(car3);
        carService.check(car3);
    }
}
