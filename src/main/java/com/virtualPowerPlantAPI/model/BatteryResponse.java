package com.virtualPowerPlantAPI.model;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

/*
    BatteryResponse
    This class exists to house both a collection of batteries, and some statistics about batteries.
    The constructor takes a list of batteries, then calculates and stores the following:
        - The average watt capacity of the batteries
        - The total watt capacity of the batteries
        - The list of batteries ordered alphabetically by name
 */
public class BatteryResponse {
    private Double capacityAverage;
    private Double capacityTotal;
    private List<Battery> batteries;
    public BatteryResponse(List<Battery> batteries) {
        this.batteries = batteries.stream().sorted(Comparator.comparing(battery -> battery.getName())).toList();

        this.capacityAverage = 0.0;
        OptionalDouble tempAve = batteries.stream().mapToDouble(b -> b.getWattCap()).average();
        if (tempAve.isPresent()) {
            this.capacityAverage = tempAve.getAsDouble();
        }

        this.capacityTotal = batteries.stream().mapToDouble(b -> b.getWattCap()).sum();
    }

    public Double getCapacityAverage() {
        return capacityAverage;
    }

    public void setCapacityAverage(Double capacityAverage) {
        this.capacityAverage = capacityAverage;
    }

    public Double getCapacityTotal() {
        return capacityTotal;
    }

    public void setCapacityTotal(Double capacityTotal) {
        this.capacityTotal = capacityTotal;
    }

    public List<Battery> getBatteries() {
        return batteries;
    }

    public void setBatteries(List<Battery> batteries) {
        this.batteries = batteries;
    }
}
