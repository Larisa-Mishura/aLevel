package com.mishura;

import com.mishura.model.Car;
import com.mishura.model.Type;
import com.mishura.repository.CarArrayRepository;
import com.mishura.service.CarService;

public class Main {

    public static void main(String[] args) {
        final CarService carService = new CarService(new CarArrayRepository());
        final Car car1 = carService.create(Type.CAR);
        car1.restore();
        final Car car2 = carService.create(Type.TRUCK);
        car2.restore();
        //System.out.println(carService.carEquals(car1, car2));
        Car car3 = null;

        carService.printManufacturerAndCount(car1);
        carService.printManufacturerAndCount(car2);
        carService.printManufacturerAndCount(car3);

        carService.printColor(car1);
        carService.printColor(car2);
        carService.printColor(car3);


        carService.printEngineInfo(car1);
        carService.printEngineInfo(car2);
        carService.printEngineInfo(car3);

        carService.printInfo(car1);
        carService.printInfo(car2);
        carService.printInfo(car3);

        carService.checkCount(car1);
        carService.checkCount(car2);
        carService.checkCount(car3);
    }
}
