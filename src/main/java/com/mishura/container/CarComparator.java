package com.mishura.container;

import com.mishura.model.Car;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return car1.getCount() - car2.getCount();
    }
}
