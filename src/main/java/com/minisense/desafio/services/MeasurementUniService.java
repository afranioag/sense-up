package com.minisense.desafio.services;

import com.minisense.desafio.dto.MeasurementUnitDto;
import com.minisense.desafio.repositories.MeasurementUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeasurementUniService {
	@Autowired
	private MeasurementUnitRepository measurementUnitRepository;
	@Transactional(readOnly = true)
	public List<MeasurementUnitDto> findAll() {
		return measurementUnitRepository.findAll().stream().map(measurementUnit -> new MeasurementUnitDto(measurementUnit))
				.collect(Collectors.toList());
	}
}



