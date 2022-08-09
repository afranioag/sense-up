package com.minisense.desafio.dto;

public class SensorDeviceResDto {
	
	private Long id;
	private String label;
	private String description;
	private String key;
	
	
	public SensorDeviceResDto() {}
	
	public SensorDeviceResDto(Long id, String label, String description, String key) {
		this.id = id;
		this.label = label;
		this.description = description;
		this.key = key;
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	

}
