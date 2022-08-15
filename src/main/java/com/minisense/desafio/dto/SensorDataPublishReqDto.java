package com.minisense.desafio.dto;

import com.minisense.desafio.entities.SensorData;

import java.io.Serializable;
import java.util.Date;

public class SensorDataPublishReqDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long unitId;
	public Long timestamp;

	public Double value;
	
	public SensorDataPublishReqDto() {}
	
	public SensorDataPublishReqDto(Long id, Long unitId, Date timestamp, Double value) {
		this.id = id;
		this.unitId = unitId;
		this.timestamp = timestamp.getTime();
		this.value = value;
	}

	public SensorDataPublishReqDto(Date timestamp, Double value) {
		this.timestamp = timestamp.getTime();
		this.value = value;
	}

	public SensorDataPublishReqDto(SensorData data) {
		this.id = data.getId();
		this.unitId = 1L;
		this.timestamp = data.getTimestamp().getTime();
		this.value = data.getValueSensor();
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	

}
