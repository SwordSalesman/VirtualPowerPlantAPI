package com.virtualPowerPlantAPI.service;

import com.virtualPowerPlantAPI.model.Battery;
import com.virtualPowerPlantAPI.repository.BatteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
    BatteryService
    Middle man between the controller and the repository.
 */
@Service
public class BatteryService {

    private final BatteryRepository batteryRepository;

    @Autowired // Denotes that the dependency will be handled by Spring
    public BatteryService(BatteryRepository batteryRepository) {
        this.batteryRepository = batteryRepository;
    }

    // Returns the list of all batteries which fall within the start and end postcode range (inclusive)
    // If no start and/or end is specified, then all batteries are returned.
    public List<Battery> getBatteriesByPostcode(Integer start, Integer end) {
        List<Battery> batteries = batteryRepository.findAll();
        if (start == null || end == null) {
            return batteries;
        }

        // Filters the list of all batteries to just the ones with postcodes in the desired range
        List<Battery> validBatteries = batteries.stream()
                .filter(battery -> (battery.getPostcode() >= start && battery.getPostcode() <= end))
                .collect(Collectors.toList());

        return validBatteries;
    }

    public void addBatteries(List<Battery> batteries) {
        batteryRepository.saveAll(batteries);
    }

}
