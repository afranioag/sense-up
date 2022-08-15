package com.minisense.desafio.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.minisense.desafio.entities.DataStream;
import com.minisense.desafio.entities.SensorDevice;

public class SensorDeviceResDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String label;
	private String description;
	
	private List<DataStreamDto> streams = new ArrayList<>();

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

	public SensorDeviceResDto(SensorDevice device, List<DataStream> streams) {
		this.id = device.getId();
		this.label = device.getLabel();
		this.description = device.getDescription();
		streams.forEach(stream -> this.streams.add(new DataStreamDto(stream)));
	}

	public SensorDeviceResDto(SensorDevice device, List<DataStream> streams, int numberOsStreams) {
		this.id = device.getId();
		this.label = device.getLabel();
		this.description = device.getDescription();
		streams.forEach(stream -> this.streams.add(new DataStreamDto(stream, numberOsStreams)));
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

	public List<DataStreamDto> getStreams() {
		return streams;
	}

	public void setStreams(List<DataStreamDto> streams) {
		this.streams = streams;
	}
	
	
}
