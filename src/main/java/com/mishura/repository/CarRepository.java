package com.mishura.repository;

import com.mishura.model.Car;

public class CarRepository {
    //CRUD
    //Create (save, insert)
    //Read (getByIG, getAll)
    //Update
    //Delete
    private Car[] cars = new Car[10];

    public void create(final Car car) {
        final int index = putCar(car);
        if (index == cars.length) {
            increaseArrayAndPut(car);
        }
    }

    private int putCar(final Car car) {
        int index = 0;
        for (; index < cars.length; index++) {
            if (cars[index] == null) {
                cars[index] = car;
                break;
            }
        }
        return index;
    }

    private void increaseArrayAndPut(final Car car){
        Car[] newCars = new Car[cars.length * 2];
        System.arraycopy(cars, 0, newCars, 0, cars.length);
        newCars[cars.length] = car;
        cars = newCars;
    }

}
