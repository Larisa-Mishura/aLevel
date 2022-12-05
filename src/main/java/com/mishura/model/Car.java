package com.mishura.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import java.util.UUID;

@Setter
@Getter
public abstract class Car implements CountRestore{
    protected final String id;
    protected String manufacturer;
    protected Engine engine;
    protected Color color;
    protected int count;
    protected int price;
    protected Type type;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(getId(), car.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
