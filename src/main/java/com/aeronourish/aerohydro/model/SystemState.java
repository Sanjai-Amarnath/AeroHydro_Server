package com.aeronourish.aerohydro.model;

import org.springframework.stereotype.Component;

@Component
public class SystemState {

    public SystemState() {
        this.mode = Mode.AUTO;             // ✅ Default mode
        this.aeroponicsOn = false;         // ✅ Default OFF
        this.hydroponicsOn = false;        // ✅ Default OFF
    }

    public enum Mode {
        AUTO,
        MANUAL
    }

    private double temperature;
    private double humidity;
    private double pH;
    private double co2;
    private double light;

    private double tempThreshold;
    private double humidityThreshold;
    private double pHThreshold;
    private double co2Threshold;
    private double lightThreshold;

    private boolean aeroponicsOn = false;
    private boolean hydroponicsOn = false;

    private Mode mode = Mode.AUTO;

    // Getters and Setters for sensor values
    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public double getHumidity() { return humidity; }
    public void setHumidity(double humidity) { this.humidity = humidity; }

    public double getPH() { return pH; }
    public void setPH(double pH) { this.pH = pH; }

    public double getCo2() { return co2; }
    public void setCo2(double co2) { this.co2 = co2; }

    public double getLight() { return light; }
    public void setLight(double light) { this.light = light; }

    // Getters and Setters for thresholds
    public double getTempThreshold() { return tempThreshold; }
    public void setTempThreshold(double tempThreshold) { this.tempThreshold = tempThreshold; }

    public double getHumidityThreshold() { return humidityThreshold; }
    public void setHumidityThreshold(double humidityThreshold) { this.humidityThreshold = humidityThreshold; }

    public double getPHThreshold() { return pHThreshold; }
    public void setPHThreshold(double pHThreshold) { this.pHThreshold = pHThreshold; }

    public double getCo2Threshold() { return co2Threshold; }
    public void setCo2Threshold(double co2Threshold) { this.co2Threshold = co2Threshold; }

    public double getLightThreshold() { return lightThreshold; }
    public void setLightThreshold(double lightThreshold) { this.lightThreshold = lightThreshold; }

    // Getters and Setters for toggle states
    public boolean isAeroponicsOn() { return aeroponicsOn; }
    public void setAeroponicsOn(boolean aeroponicsOn) { this.aeroponicsOn = aeroponicsOn; }

    public boolean isHydroponicsOn() { return hydroponicsOn; }
    public void setHydroponicsOn(boolean hydroponicsOn) { this.hydroponicsOn = hydroponicsOn; }

    // Mode getter/setter
    public Mode getMode() { return mode; }
    public void setMode(Mode mode) { this.mode = mode; }
}
