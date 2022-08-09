package com.minisense.desafio.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sensorData")
public class SensorData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date timestamp;
	private Double valueSensor;
	
	public SensorData() {}

	public SensorData(Long id, Double valueSensor, Date timestamp) {
		this.id = id;
		this.valueSensor = valueSensor;
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValueSensor() {
		return valueSensor;
	}

	public void setValueSensor(Double valueSensor) {
		this.valueSensor = valueSensor;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
