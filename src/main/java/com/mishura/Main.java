package com.mishura;

import com.mishura.model.Car;
import com.mishura.model.PassengerCar;
import com.mishura.model.Truck;
import com.mishura.repository.CarArrayRepository;
import com.mishura.service.CarService;

public class Main {

    public static void main(String[] args) {
        final CarService carService = new CarService(new CarArrayRepository());

        final PassengerCar car1 = carService.createPassengerCar();
        car1.restore();

        final Truck car2 = carService.createTruck();
        car2.restore();
    }
}
