package com.mishura;

import com.mishura.model.Car;
import com.mishura.model.PassengerCar;
import com.mishura.model.Type;
import com.mishura.repository.CarArrayRepository;
import com.mishura.service.CarService;
import com.mishura.util.AlgorithmUtil;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final CarService carService = new CarService(new CarArrayRepository());
        carService.create(3, Type.CAR);
        carService.create(3, Type.TRUCK);
        carService.printAll();
        Car[] cars = carService.getAll();
        Car car1 = cars[1];
        Car car2 = cars[2];

        System.out.println(AlgorithmUtil.binarySearch(cars, car1));
        System.out.println(AlgorithmUtil.binarySearch(cars, car2));
    }
}
