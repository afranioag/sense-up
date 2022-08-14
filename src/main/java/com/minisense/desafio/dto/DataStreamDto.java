package com.minisense.desafio.dto;

import com.minisense.desafio.entities.DataStream;

import java.io.Serializable;

public class DataStreamDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String label;
	private Long deviceId;
	private Long unitId;
	private int measurementCount;


	public DataStreamDto() {}
	
	public DataStreamDto(Long id, String label, Long deviceId, Long unitId, int measurementCount) {
		this.id = id;
		this.label = label;
		this.deviceId = deviceId;
		this.unitId = unitId;
		this.measurementCount = measurementCount;
	}

	public DataStreamDto(DataStream stream) {
		this.id = stream.getId();
		this.label = stream.getLabel();
		this.deviceId = stream.getSensorDevice().getId();
		this.unitId = stream.getUnit().getId();
		this.measurementCount = stream.getCollects().size();
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

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public int getMeasurementCount() {
		return measurementCount;
	}

	public void setMeasurementCount(int measurementCount) {
		this.measurementCount = measurementCount;
	}
	
}
