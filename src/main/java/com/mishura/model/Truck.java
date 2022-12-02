package com.mishura.model;

public class Truck extends Car{
    private int loadCapacity;
    private Type type = Type.TRUCK;

    public Truck() {
        super();
    }

    public Truck(Color color){
        super(color);
    }

    public Truck(String manufacturer, Engine engine, Color color) {
        super(manufacturer, engine, color);
    }

    @Override
    public void restore() {
        this.setCount(50);
        System.out.println("Кількість машин змінено на " + this.getCount());
    }
}
