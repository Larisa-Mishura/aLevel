package com.mishura;

import com.mishura.model.Car;
import com.mishura.model.PassengerCar;
import com.mishura.model.Truck;
import com.mishura.model.Type;
import com.mishura.repository.CarArrayRepository;
import com.mishura.service.CarService;
import com.mishura.util.RandomGenerator;
import lombok.NonNull;

public class Main {

    public static void main(String[] args) {
        final CarService carService = new CarService(new CarArrayRepository());

        final Car car1 = carService.create(Type.CAR);
        car1.restore();

        final Car car2 = carService.create(Type.TRUCK);
        car2.restore();

        System.out.println(carService.carEquals(car1, car2));
    }
}
