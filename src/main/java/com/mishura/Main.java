package com.mishura;

import com.mishura.model.Car;
import com.mishura.model.Color;
import com.mishura.repository.CarArrayRepository;
import com.mishura.service.CarService;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final CarService carService = new CarService(new CarArrayRepository());

        final Car car1 = carService.create();
        carService.printAll();

        System.out.println(carService.find(car1.getId()));

        carService.create(3);
        carService.printAll();

        carService.delete(car1.getId());
        carService.printAll();

        Car[] all = carService.getAll();
        final Car car2 = all[0];
        carService.changeRandomColor(car2.getId());
        System.out.println(carService.find(car2.getId()));

        //hw7:
        for (Car car : all) {
            carService.check(car);
        }

        // insert():
        final Car car3 = new Car(Color.RED);
        carService.insert(1, car3);
        all = carService.getAll();
        System.out.println(Arrays.toString(all));
    }
}
