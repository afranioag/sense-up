package com.minisense.desafio.dto;

public class DataStreamReqDto {

	private String labal;
	private Long unitId;
	
	
	public DataStreamReqDto() {}
	
	public DataStreamReqDto(String labal, Long unitId) {
		this.labal = labal;
		this.unitId = unitId;
	}

	public String getLabal() {
		return labal;
	}

	public void setLabal(String labal) {
		this.labal = labal;
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}
	
	
	
}
