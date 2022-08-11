package com.minisense.desafio.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.minisense.desafio.entities.SensorDevice;

public class GetSensorDeviceDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String key;
	private String label;
	private String description;
	
	private List<DataStreamResDto> streams = new ArrayList<>();

	public GetSensorDeviceDto() {}
	
	public GetSensorDeviceDto(Long id, String key, String label, String description) {
		this.id = id;
		this.key = key;
		this.label = label;
		this.description = description;
	}
	
	public GetSensorDeviceDto(SensorDevice device) {
		this.id = device.getId();
		this.key = device.getKeyDevice();
		this.label = device.getLabel();
		this.description = device.getDescription();
		//this.streams = device.getStreams();
	}
	
//	public GetSensorDeviceDto(SensorDevice device, List<DataStreamResDto> streams) {
//		this(device);
//		streams.forEach(stream -> this.streams.add(new StreamDto(stream))); // Falta criar esse detalhe para salvar a lista de streams
//	}


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
