package com.mishura.repository;

import com.mishura.model.Car;
import com.mishura.model.Color;

//    CRUD
//    Create (Save, Insert)
//    Read (getById, getAll)
//    Update
//    Delete
public class CarArrayRepository implements GenericInterface<Car>{
    private static Car[] cars = new Car[10];

    private static CarArrayRepository instance;

    private CarArrayRepository(){

    }

    public static CarArrayRepository getInstance(){
        if (instance == null){
            instance = new CarArrayRepository();
        }
        return instance;
    }

    public void save(final Car car) {
        final int index = putCar(car);
        if (index == cars.length) {
            final int oldLength = cars.length;
            increaseArray();
            cars[oldLength] = car;
        }
    }

    public void insert(int index, Car car) {
        if (index < foundLength()){
            if (foundLength() == cars.length){
                increaseArray();
            }
            System.arraycopy(cars, index, cars, index + 1, foundLength() - index);
            cars[index] = null;
        }
        save(car);
    }

    public Car[] getAll() {
        final int newLength = foundLength();
        final Car[] newCars = new Car[newLength];
        System.arraycopy(cars, 0, newCars, 0, newLength);
        return newCars;
    }

    public Car getByIG(final String id) {
        for (Car car : cars) {
            if(car.getId().equals(id)){
                return car;
            }
        }
        return null;
    }

    public void delete(final String id) {
        int index = 0;
        for ( ; index < cars.length; index++) {
            if(cars[index].getId().equals(id)){
                break;
            }
        }
        if(index != cars.length){
            System.arraycopy(cars, index + 1, cars, index, cars.length - (index+1));
        }
    }

    public void updateColor(final String id, final Color color){
        final Car car = getByIG(id);
        if(car != null){
            car.setColor(color);
        }
    }

    private int foundLength(){
        int newLength = 0;
        for (Car car : cars) {
            if(car != null){
                newLength++;
            } else {
                break;
            }
        }
        return newLength;
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

    private void increaseArray(){
        Car[] newCars = new Car[cars.length * 2];
        System.arraycopy(cars, 0, newCars, 0, cars.length);
        cars = newCars;
    }
}

