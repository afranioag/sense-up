package com.minisense.desafio.dto;

import java.io.Serializable;

public class SensorDeviceReqDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private String label;
	private String description;
	
	
	public SensorDeviceReqDto() {}
	
	public SensorDeviceReqDto(Long id, String label, String description, String key) {
		this.label = label;
		this.description = description;
	}


	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
