package com.mishura.model;

import java.util.Random;

public class Engine {
    private int power;
    private String type;

    Random random = new Random();

    public Engine(String type) {
        this.power = random.nextInt(1000);
        this.type = type;
    }

    public Engine() {
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type + "-" + this.power;
    }
}
