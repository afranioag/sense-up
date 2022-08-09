package com.minisense.desafio.dto;

public class DataStreamResDto {

	private Long id;
	private String key;
	private String labal;
	private Long deviceId;
	private Long unitId;
	private int measurementCount;
	private String name;
	
	public DataStreamResDto() {}
	
	public DataStreamResDto(Long id, String key, String labal, Long deviceId, Long unitId, int measurementCount) {
		this.id = id;
		this.key = key;
		this.labal = labal;
		this.deviceId = deviceId;
		this.unitId = unitId;
		this.measurementCount = measurementCount;
	}
	

	public DataStreamResDto(Long id, String key, String labal, Long deviceId, Long unitId, int measurementCount,
			String name) {
		this.id = id;
		this.key = key;
		this.labal = labal;
		this.deviceId = deviceId;
		this.unitId = unitId;
		this.measurementCount = measurementCount;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLabal() {
		return labal;
	}

	public void setLabal(String labal) {
		this.labal = labal;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
