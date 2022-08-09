package com.minisense.desafio.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_dataStream")
public class DataStream implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String label;
	private Boolean enabled = false;
	
	
	@OneToMany(mappedBy = "streams")
	private List<SensorData> collects = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "unit_id")
	private MeasurementUnit unit;
	
	@ManyToOne
	@JoinColumn(name = "device_id")
	private SensorDevice sensorDevice;
	
	
	public DataStream() {}

	public DataStream(Long id, String label, MeasurementUnit unit ) {
		super();
		this.id = id;
		this.label = label;
		this.unit = unit;
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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public SensorDevice getSensorDevice() {
		return sensorDevice;
	}

	public void setSensorDevice(SensorDevice sensorDevice) {
		this.sensorDevice = sensorDevice;
	}
	
	public List<SensorData> getCollects() {
		return collects;
	}
	
	public MeasurementUnit getUnit() {
		return unit;
	}

	public void setUnit(MeasurementUnit unit) {
		this.unit = unit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataStream other = (DataStream) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
