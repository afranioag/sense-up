package com.minisense.desafio.dto;

import com.minisense.desafio.entities.SensorData;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

public class SensorDataPublishDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long unitId;
	@NotBlank(message = "timestamp not empty")
	public Long timestamp;

	@NotBlank(message = "value not empty")
	public Double value;
	
	public SensorDataPublishDto() {}
	
	public SensorDataPublishDto(Long id, Long unitId, Date timestamp, Double value) {
		this.id = id;
		this.unitId = unitId;
		this.timestamp = timestamp.getTime();
		this.value = value;
	}

	public SensorDataPublishDto(Date timestamp, Double value) {
		this.timestamp = timestamp.getTime();
		this.value = value;
	}

	public SensorDataPublishDto(SensorData data) {
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
