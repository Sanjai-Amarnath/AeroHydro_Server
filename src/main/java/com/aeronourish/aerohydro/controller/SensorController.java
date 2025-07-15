package com.aeronourish.aerohydro.controller;

import com.aeronourish.aerohydro.model.SensorData;
import com.aeronourish.aerohydro.model.Thresholds;
import com.aeronourish.aerohydro.model.ToggleStatus;
import com.aeronourish.aerohydro.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sensor")

public class SensorController {

    private final ToggleStatus toggleStatus=new ToggleStatus();
    private final Thresholds threshold=new Thresholds();
    private final SystemService systemService;

    @Autowired
    public SensorController(SystemService systemService){
        this.systemService=systemService;
    }

    @Autowired
    private com.aeronourish.aerohydro.model.SystemState systemState;

    @PostMapping("/send")
    public String receiveSensorData(@RequestBody SensorData data){
        systemService.processSensorData(data);
        return "Sensor data received";
    }

    @GetMapping("/status")
    public ToggleStatus getToggleStatus() {
        ToggleStatus status = new ToggleStatus();
        status.setAeroponics(systemState.isAeroponicsOn());
        status.setHydroponics(systemState.isHydroponicsOn());

        System.out.println("DEBUG STATUS -> Aero: " + status.isAeroponics() + " | Hydro: " + status.isHydroponics());
        return status;
    }


    @GetMapping("/latest")
    public SensorData getLatest(){
        return systemService.getLatestSensorData();
    }
}
