package com.aeronourish.aerohydro.model;

public class Thresholds {
    public double temperature;
    public double humidity;
    public double pH;
    public double co2;
    public double light;

    public Thresholds() {}

    public Thresholds(double temperature, double humidity, double pH, double co2, double light) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pH = pH;
        this.co2 = co2;
        this.light = light;
    }
}
