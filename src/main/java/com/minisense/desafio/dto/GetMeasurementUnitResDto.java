package com.minisense.desafio.dto;

public class GetMeasurementUnitResDto {

	private Long id;
	private String symbol;
	private String description;
	
	
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
