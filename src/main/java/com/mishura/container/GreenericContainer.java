package com.mishura.container;

import com.mishura.model.Car;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.Random;

public class GreenericContainer <T extends Car>{
    T car;
    private Random random = new Random();

    public GreenericContainer(T car){
        this.car = car;
    }

    public T getCar() {
        return car;
    }

    public void setCar(T car) {
        this.car = car;
    }

    public void print(){
        System.out.println(car.toString());
    }

    public void increaseCount(){
        car.setCount(car.getCount() + random.nextInt(200) + 100);
    }

    public void increaseCount(Optional<? extends Number> optional){
        optional.ifPresent(value ->car.setCount(car.getCount() + value.intValue()));
    }
}