package com.minisense.desafio.dto;

import java.time.Instant;

public class PublishDataStreamReqDto {
	
	public Instant timestamp;
	public Double value;
	
	
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
