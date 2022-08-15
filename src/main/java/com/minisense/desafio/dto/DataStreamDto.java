package com.minisense.desafio.dto;

import com.minisense.desafio.entities.DataStream;
import com.minisense.desafio.entities.SensorData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataStreamDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String label;
	private Long deviceId;
	private Long unitId;
	private int measurementCount;

	private List<SensorDataPublishShowDto> measurements;

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

	public DataStreamDto(DataStream stream, int numberOsStreams) {
		this.measurements = new ArrayList<>();

		this.id = stream.getId();
		this.label = stream.getLabel();
		this.deviceId = stream.getSensorDevice().getId();
		this.unitId = stream.getUnit().getId();
		this.measurementCount = stream.getCollects().size();
		showPublish(stream.getCollects(), numberOsStreams);
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

	public List<SensorDataPublishShowDto> getMeasurements() {
		return measurements;
	}

	private void showPublish(List<SensorData> collects,  int numberOfStreams) {
		if(numberOfStreams < 0 ) {
			collects.forEach(str -> this.measurements.add(new SensorDataPublishShowDto(str)));
		} else {
			numberOfStreams = collects.size() < numberOfStreams ? collects.size() : numberOfStreams;
			int lastIndex = collects.size() - 1;

			while (numberOfStreams > 0) {
				this.measurements.add(
						new SensorDataPublishShowDto(collects.get(lastIndex)));
				numberOfStreams -= 1;
				lastIndex -= 1;
			}
		}
	}
}
