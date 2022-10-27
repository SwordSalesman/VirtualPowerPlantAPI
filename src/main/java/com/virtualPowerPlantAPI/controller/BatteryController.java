package com.virtualPowerPlantAPI.controller;

import com.virtualPowerPlantAPI.model.Battery;
import com.virtualPowerPlantAPI.model.BatteryResponse;
import com.virtualPowerPlantAPI.service.BatteryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    BatteryController
    Used to map HTTP requests to functions to interact with the database through a service.
 */
@RestController
@RequestMapping(path="api/v1/battery")
public class BatteryController {

    private final BatteryService batteryService;

    public BatteryController(BatteryService batteryService) {
        this.batteryService = batteryService;
    }

    @GetMapping
    public BatteryResponse getBatteriesByPostcode(Integer start, Integer end) {
        return new BatteryResponse( batteryService.getBatteriesByPostcode(start, end) );
    }

    @PostMapping // Spring annotation for HTTP POST requests
        // @RequestBody tells Spring to convert the received JSON payload into a Battery object
    public void addBatteries(@RequestBody List<Battery> batteries) {
        batteryService.addBatteries(batteries);
    }

}
