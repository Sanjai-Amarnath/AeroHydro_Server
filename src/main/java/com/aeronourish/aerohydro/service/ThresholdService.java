package com.aeronourish.aerohydro.service;

import com.aeronourish.aerohydro.model.Thresholds;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ThresholdService {

    private Thresholds currentThresholds = new Thresholds();

    public Map<String, Double> getThresholds() {
        Map<String, Double> map = new HashMap<>();
        map.put("temperature", currentThresholds.temperature);
        map.put("humidity", currentThresholds.humidity);
        map.put("pH", currentThresholds.pH);
        map.put("co2", currentThresholds.co2);
        map.put("light", currentThresholds.light);
        return map;
    }


    public void saveThresholds(Thresholds newThresholds) {
        this.currentThresholds = newThresholds;
    }
}
