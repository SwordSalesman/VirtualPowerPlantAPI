package com.virtualPowerPlantAPI.repository;

import com.virtualPowerPlantAPI.model.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
    BatteryRepository
    Used to facilitate interactions between battery models in memory and in the database
 */
@Repository
public interface BatteryRepository extends JpaRepository<Battery, Integer> {

}
