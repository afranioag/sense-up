package com.minisense.desafio.dto;

import com.minisense.desafio.entities.SensorData;

import java.io.Serializable;
import java.util.Date;

public class SensorDataPublishShowDto implements Serializable{
	private static final long serialVersionUID = 1L;

	public Long timestamp;
	public Double value;

	public SensorDataPublishShowDto() {}

	public SensorDataPublishShowDto( Date timestamp, Double value) {
		this.timestamp = timestamp.getTime();
		this.value = value;
	}


	public SensorDataPublishShowDto(SensorData data) {
		this.timestamp = data.getTimestamp().getTime();
		this.value = data.getValueSensor();
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
