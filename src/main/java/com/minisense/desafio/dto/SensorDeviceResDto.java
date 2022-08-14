package com.minisense.desafio.dto;

import com.minisense.desafio.entities.SensorDevice;

import java.io.Serializable;

public class SensorDeviceResDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String label;
	private String description;
	
	
	public SensorDeviceResDto() {}
	
	public SensorDeviceResDto(Long id, String label, String description) {
		this.id = id;
		this.label = label;
		this.description = description;
	}
	public SensorDeviceResDto(SensorDevice device) {
		this.id = device.getId();
		this.label = device.getLabel();
		this.description = device.getDescription();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
