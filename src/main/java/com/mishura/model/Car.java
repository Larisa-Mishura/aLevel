package com.mishura.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Setter
@Getter
public abstract class Car implements CountRestore{
    private final String id;
    private String manufacturer;
    private Engine engine;
    private Color color;
    private int count;
    private int price;
    private Type type;

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

    @Override
    public String toString() {
        return String.format("[%s] %s", id, color);
    }
}
