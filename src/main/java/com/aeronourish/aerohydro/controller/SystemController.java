package com.aeronourish.aerohydro.controller;

import com.aeronourish.aerohydro.model.SystemState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/system")
@CrossOrigin(origins = "*")
public class SystemController {

    @Autowired
    private SystemState systemState;

    // ✅ Manual toggle: always allowed
    @PostMapping("/toggle")
    public ResponseEntity<String> toggleSystems(@RequestBody Map<String, Boolean> toggles) {
        if (toggles.containsKey("aeroponics") && toggles.get("aeroponics")) {
            systemState.setAeroponicsOn(true);
            systemState.setHydroponicsOn(false); // auto-turn off other
        } else if (toggles.containsKey("hydroponics") && toggles.get("hydroponics")) {
            systemState.setHydroponicsOn(true);
            systemState.setAeroponicsOn(false); // auto-turn off other
        } else {
            // Explicit off request
            if (toggles.containsKey("aeroponics")) {
                systemState.setAeroponicsOn(false);
            }
            if (toggles.containsKey("hydroponics")) {
                systemState.setHydroponicsOn(false);
            }
        }

        // 🔍 Add this debug print:
        System.out.println("DEBUG TOGGLE -> Aero: " + systemState.isAeroponicsOn()
                + " | Hydro: " + systemState.isHydroponicsOn());

        return ResponseEntity.ok("Toggles applied.");
    }




}
