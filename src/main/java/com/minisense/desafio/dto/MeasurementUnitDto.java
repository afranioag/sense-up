package com.minisense.desafio.dto;

import com.minisense.desafio.entities.MeasurementUnit;

import java.io.Serializable;

public class MeasurementUnitDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String symbol;
	private String description;
	
	public MeasurementUnitDto() {}
	
	public MeasurementUnitDto(Long id, String symbol, String description) {
		this.id = id;
		this.symbol = symbol;
		this.description = description;
	}

	public MeasurementUnitDto(MeasurementUnit measurementUnit) {
		this.id = measurementUnit.getId();
		this.symbol = measurementUnit.getSymbol();
		this.description = measurementUnit.getDescription();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
