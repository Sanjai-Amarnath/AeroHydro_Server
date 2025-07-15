package com.aeronourish.aerohydro.controller;

import com.aeronourish.aerohydro.model.Thresholds;
import com.aeronourish.aerohydro.service.PlantThresholdService;
import com.aeronourish.aerohydro.service.SystemService;
import com.aeronourish.aerohydro.service.ThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/threshold")
public class ThresholdController {

    private final ThresholdService thresholdService;
    private final SystemService systemService;
    private final PlantThresholdService plantThresholdService;

    @Autowired
    public ThresholdController(SystemService systemService,
                               ThresholdService thresholdService,
                               PlantThresholdService plantThresholdService) {
        this.systemService = systemService;
        this.thresholdService = thresholdService;
        this.plantThresholdService = plantThresholdService;
    }

    // ✅ Set thresholds manually
    @PostMapping("/set")
    public String updateThresholds(@RequestBody Thresholds newThresholds) {
        thresholdService.saveThresholds(newThresholds);
        return "Thresholds set successfully";
    }

    // ✅ Get current active thresholds
    @GetMapping("/get")
    public Map<String, Double> getThresholds() {
        return thresholdService.getThresholds();
    }

    // ✅ Get thresholds for a specific plant
    @GetMapping("/plant/{plantName}")
    public Thresholds getThresholdsForPlant(@PathVariable String plantName) {
        return plantThresholdService.getThresholdsForPlant(plantName);
    }

    // ✅ Get all available plants and their thresholds
    @GetMapping("/plant")
    public Map<String, Thresholds> getAllPlantThresholds() {
        return plantThresholdService.getAllPlantThresholds();
    }
}
