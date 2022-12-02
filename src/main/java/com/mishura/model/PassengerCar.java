package com.mishura.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PassengerCar extends Car{
    private int passengerCount;
    private Type type = Type.CAR;

    public PassengerCar() {
        super();
    }

    public PassengerCar(Color color){
        super(color);
    }

    public PassengerCar(String manufacturer, Engine engine, Color color) {
        super(manufacturer, engine, color);
    }

    @Override
    public void restore() {
        this.setCount(100);
        System.out.println("Кількість машин змінено на " + this.getCount());
    }
}
