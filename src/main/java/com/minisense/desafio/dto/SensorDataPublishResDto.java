package com.minisense.desafio.dto;

import com.minisense.desafio.entities.SensorData;

import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Date;

public class SensorDataPublishResDto implements Serializable{
	private static final long serialVersionUID = 1L;

	@Positive
	public Long timestamp;

	public Double value;

	public SensorDataPublishResDto() {}

	public SensorDataPublishResDto(Date timestamp, Double value) {
		this.timestamp = timestamp.getTime();
		this.value = value;
	}

	public SensorDataPublishResDto(SensorData data) {
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
