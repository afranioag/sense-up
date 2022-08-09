package com.minisense.desafio.dto;

import java.io.Serializable;
import java.time.Instant;

public class PublishDataStreamReqDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public Instant timestamp;
	public Double value;
	
	public PublishDataStreamReqDto() {}
	
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
