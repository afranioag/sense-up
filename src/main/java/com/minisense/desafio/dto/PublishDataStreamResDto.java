package com.minisense.desafio.dto;

import java.time.Instant;

public class PublishDataStreamResDto {
	
	private Long id;
	private Long unitId;
	public Instant timestamp;
	public Double value;
	
	public PublishDataStreamResDto() {}
	
	public PublishDataStreamResDto(Long id, Long unitId, Instant timestamp, Double value) {
		super();
		this.id = id;
		this.unitId = unitId;
		this.timestamp = timestamp;
		this.value = value;
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

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	

}
