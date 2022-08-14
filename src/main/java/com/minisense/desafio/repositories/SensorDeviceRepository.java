package com.minisense.desafio.repositories;

import com.minisense.desafio.entities.SensorDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDeviceRepository extends JpaRepository<SensorDevice, Long>{

}
