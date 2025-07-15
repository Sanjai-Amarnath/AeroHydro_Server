package com.aeronourish.aerohydro.service;

import com.aeronourish.aerohydro.model.SensorData;
import org.springframework.stereotype.Service;

@Service
public class SensorService {

    private SensorData latestData = new SensorData();

    public SensorData getLatestSensorData() {
        return latestData;
    }

    public void updateSensorData(SensorData data) {
        this.latestData = data;
    }
}
