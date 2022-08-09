package com.minisense.desafio.dto;

import java.io.Serializable;

public class GetMeasurementUnitResDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String symbol;
	private String description;
	
	public GetMeasurementUnitResDto() {}
	
	public GetMeasurementUnitResDto(Long id, String symbol, String description) {
		this.id = id;
		this.symbol = symbol;
		this.description = description;
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
