package com.aeronourish.aerohydro.model;

public class ToggleStatus {
    private boolean aeroponics;
    private boolean hydroponics;

    public boolean isAeroponics() {
        return aeroponics;
    }

    public void setAeroponics(boolean aeroponics) {
        this.aeroponics = aeroponics;
    }

    public boolean isHydroponics() {
        return hydroponics;
    }

    public void setHydroponics(boolean hydroponics) {
        this.hydroponics = hydroponics;
    }
}

