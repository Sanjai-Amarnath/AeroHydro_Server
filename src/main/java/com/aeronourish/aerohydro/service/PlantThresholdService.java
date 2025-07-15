package com.aeronourish.aerohydro.service;

import com.aeronourish.aerohydro.model.Thresholds;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PlantThresholdService {

    private final Map<String, Thresholds> plantThresholds = new HashMap<>();

    public PlantThresholdService() {
        // Define thresholds for each plant
        plantThresholds.put("Tomato", new Thresholds(25.0, 60.0, 6.0, 800.0, 400.0));
        plantThresholds.put("Lettuce", new Thresholds(20.0, 70.0, 6.5, 700.0, 350.0));
        plantThresholds.put("Spinach", new Thresholds(18.0, 65.0, 6.8, 750.0, 360.0));
    }

    public Thresholds getThresholdsForPlant(String plant) {
        return plantThresholds.getOrDefault(plant, new Thresholds());
    }

    public Map<String, Thresholds> getAllPlantThresholds() {
        return plantThresholds;
    }
}
