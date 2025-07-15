package com.aeronourish.aerohydro.service;

import com.aeronourish.aerohydro.model.SensorData;
import com.aeronourish.aerohydro.model.SystemState;
import com.aeronourish.aerohydro.model.SystemState.Mode;
import com.aeronourish.aerohydro.model.Thresholds;
import com.aeronourish.aerohydro.model.ToggleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemService {

    @Autowired
    private SystemState systemState;

    public void updateThreshold(Thresholds newThresholds) {
        systemState.setTempThreshold(newThresholds.temperature);
        systemState.setHumidityThreshold(newThresholds.humidity);
        systemState.setPHThreshold(newThresholds.pH);
        systemState.setCo2Threshold(newThresholds.co2);
        systemState.setLightThreshold(newThresholds.light);
    }

    public Thresholds getThresholds() {
        Thresholds t = new Thresholds();
        t.temperature = systemState.getTempThreshold();
        t.humidity = systemState.getHumidityThreshold();
        t.pH = systemState.getPHThreshold();
        t.co2 = systemState.getCo2Threshold();
        t.light = systemState.getLightThreshold();
        return t;
    }

    public void processSensorData(SensorData data) {
        systemState.setTemperature(data.temperature);
        systemState.setHumidity(data.humidity);
        systemState.setPH(data.pH);
        systemState.setCo2(data.co2);
        systemState.setLight(data.light);
        }

    public ToggleStatus getToggleStatus() {
        ToggleStatus status = new ToggleStatus();
        status.setAeroponics(systemState.isAeroponicsOn());
        status.setHydroponics(systemState.isHydroponicsOn());
        return status;
    }

    public SensorData getLatestSensorData() {
        SensorData data = new SensorData();
        data.temperature = systemState.getTemperature();
        data.humidity = systemState.getHumidity();
        data.pH = systemState.getPH();
        data.co2 = systemState.getCo2();
        data.light = systemState.getLight();
        return data;
    }
}
