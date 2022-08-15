package com.minisense.desafio.controllers;

import com.minisense.desafio.dto.MeasurementUnitDto;
import com.minisense.desafio.services.MeasurementUniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/measurements")
public class MeasurementUnitController {

    @Autowired
    private MeasurementUniService measurementUniService;

    @GetMapping
    public ResponseEntity<List<MeasurementUnitDto>> findAll() {
        return ResponseEntity.ok().body(measurementUniService.findAll());
    }
}
