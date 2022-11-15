package com.mishura.model;

import java.util.UUID;

public class Car {
    private final String id;
    private String manufacturer;
    private Engine engine;
    private Color color;
    private int count;
    private int price;

    public Car() {
        this.id = UUID.randomUUID().toString();
        this.count = 1;
    }

    public Car(Color color) {
        this.id = UUID.randomUUID().toString();
        this.color = color;
        this.count = 1;
        this.price = (int) (Math.random() * 100000000);
    }

    public Car(String manufacturer, Engine engine, Color color) {
        this.id = UUID.randomUUID().toString();
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.color = color;
        this.count = 1;
        this.price = (int) (Math.random() * 100000000);
    }

    public String getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(final String manufacture) {
        this.manufacturer = manufacture;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(final Engine engine) {
        this.engine = engine;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(final Color color) {
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

    @Override
    public String toString() {
        return String.format("[%s] %s", id, color);
    }
}
