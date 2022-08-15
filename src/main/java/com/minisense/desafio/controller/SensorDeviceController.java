package com.minisense.desafio.controller;

import com.minisense.desafio.dto.*;
import com.minisense.desafio.services.MeasurementUniService;
import com.minisense.desafio.services.SensorDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/sensors/users")
public class SensorDeviceController {

    @Autowired
    private SensorDeviceService deviceService;

    @PostMapping(value = "/{id}/devices")
    public ResponseEntity<SensorDeviceResDto> insertDevice(@PathVariable Long id, @Valid @RequestBody SensorDeviceResDto dto) {
        dto = deviceService.save(id, dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PostMapping(value = "/devices/{id}/streams")
    public ResponseEntity<DataStreamDto> insertStream(@PathVariable Long id, @Valid @RequestBody DataStreamDto dto) {
        dto = deviceService.insertStream(id, dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PostMapping(value = "/devices/streams/{id}/measurements")
    public ResponseEntity<SensorDataPublishDto> insertMeasurements(@PathVariable Long id, @Valid @RequestBody SensorDataPublishDto dto) {
        dto = deviceService.insertMeasurement(id, dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping(value = "/{id}/devices")
    public ResponseEntity<List<SensorDeviceDto>> findAllDevices(@PathVariable Long id) {
        return ResponseEntity.ok().body(deviceService.findAllDevices(id));
    }

    @GetMapping(value = "/devices/{id}")
    public ResponseEntity<SensorDeviceDto> deviceFindById(@PathVariable Long id) {
        return ResponseEntity.ok().body(deviceService.deviceFindById(id));
    }

    @GetMapping(value = "/devices/streams/{id}")
    public ResponseEntity<DataStreamDto> streamFindById(@PathVariable Long id) {
        return ResponseEntity.ok().body(deviceService.streamFindById(id));
    }

}
