package com.minisense.desafio.controller;

import com.minisense.desafio.dto.*;
import com.minisense.desafio.services.MeasurementUniService;
import com.minisense.desafio.services.SensorDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/devices")
public class SensorDeviceController {

    @Autowired
    private SensorDeviceService deviceService;

    @PostMapping(value = "/users/{id}")
    public ResponseEntity<SensorDeviceResDto> save(@PathVariable Long id, @RequestBody SensorDeviceResDto dto) {
        dto = deviceService.save(id, dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PostMapping(value = "/{id}/streams")
    public ResponseEntity<DataStreamDto> insertStream(@PathVariable Long id, @RequestBody DataStreamDto dto) {
        dto = deviceService.insertStream(id, dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PostMapping(value = "/streams/{id}/measurements")
    public ResponseEntity<SensorDataPublishDto> insertMeasurements(@PathVariable Long id, @RequestBody SensorDataPublishDto dto) {
        dto = deviceService.insertMeasurement(id, dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
