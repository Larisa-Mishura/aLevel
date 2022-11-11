package com.mishura.model;

public class Engine {
    private int power;
    private String type;

    public Engine(int power, String type) {
        if( (power >= 0) && (power <=1000)) {
            this.power = power;
        }
        this.type = type;
    }

    public Engine() {
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if( (power >= 0) && (power <=1000)) {
            this.power = power;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type + " - " + this.power;
    }
}
