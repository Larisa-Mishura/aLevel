package com.mishura.model;

import java.util.Random;

public class Car {
    private String manufacturer;
    private String engine;
    private String color;
    private int count;
    private int price;

    public Car(){
    }

    public Car(String manufacturer, String engine, String color) {
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.color = color;
        this.count = 1;
        this.price = (int)(Math.random()*100000000);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(final String manufacture) {
        this.manufacturer = manufacture;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(final String engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(final int price) {
        this.price = price;
    }
}
