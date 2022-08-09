package com.minisense.desafio.dto;

import java.util.ArrayList;
import java.util.List;

import com.minisense.desafio.entities.SensorDevice;

public class GetSensorDeviceDto {

	private Long id;
	private String key;
	private String label;
	private String description;
	private List<DataStreamResDto> streams = new ArrayList<>();

	
	public GetSensorDeviceDto(Long id, String key, String label, String description, List<DataStreamResDto> streams) {
		this.id = id;
		this.key = key;
		this.label = label;
		this.description = description;
		this.streams = streams;
	}
	
	public GetSensorDeviceDto(SensorDevice device) {
		this.id = device.getId();
		this.key = device.getKeyDevice();
		this.label = device.getLabel();
		this.description = device.getDescription();
		// this.streams = device.getStreams(); falta implementar
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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

	public List<DataStreamResDto> getStreams() {
		return streams;
	}

	public void setStreams(List<DataStreamResDto> streams) {
		this.streams = streams;
	}
	
	
}
