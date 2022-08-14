package com.minisense.desafio.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_sensorData")
public class SensorData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date timestamp;
	private Double valueSensor;
	
	@ManyToOne
	@JoinColumn(name = "dataStream_id")
	private DataStream streams;
	
	@ManyToOne
	@JoinColumn(name = "unit_id")
	private MeasurementUnit unit;
	
	public SensorData() {}

	public SensorData(Long id, Double valueSensor, Date timestamp, DataStream streams) {
		this.id = id;
		this.valueSensor = valueSensor;
		this.timestamp = timestamp;
		this.streams = streams;
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

	public DataStream getStreams() {
		return streams;
	}

	public void setStreams(DataStream streams) {
		this.streams = streams;
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
		SensorData other = (SensorData) obj;
		return Objects.equals(id, other.id);
	}
}
