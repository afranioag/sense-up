package com.minisense.desafio.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sensorDevice")
public class SensorDevice implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String keyDevice;
	private String label;
	private String description;
	
	
	public SensorDevice() {}

	public SensorDevice(Long id, String keyDevice, String label, String description) {
		this.id = id;
		this.keyDevice = keyDevice;
		this.label = label;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeyDevice() {
		return keyDevice;
	}

	public void setKeyDevice(String keyDevice) {
		this.keyDevice = keyDevice;
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
	
	
	

}
