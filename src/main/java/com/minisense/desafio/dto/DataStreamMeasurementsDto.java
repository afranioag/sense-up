package com.minisense.desafio.dto;

import com.minisense.desafio.entities.DataStream;
import com.minisense.desafio.entities.SensorData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataStreamMeasurementsDto extends DataStreamDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<SensorDataPublishResDto> measurements = new ArrayList<>();

	public DataStreamMeasurementsDto() {}

	public DataStreamMeasurementsDto(DataStream stream, int numberOsStreams) {
		super(stream);
		showPublish(stream.getCollects(), numberOsStreams);
	}

	public List<SensorDataPublishResDto> getMeasurements() {
		return measurements;
	}
	private void showPublish(List<SensorData> collects,  int numberOfStreams) {
		if(numberOfStreams < 0 ) {
			collects.forEach(str -> this.measurements.add(new SensorDataPublishResDto(str)));
		} else {
			numberOfStreams = collects.size() < numberOfStreams ? collects.size() : numberOfStreams;
			int lastIndex = collects.size() - 1;

			while (numberOfStreams > 0) {
				this.measurements.add(
						new SensorDataPublishResDto(collects.get(lastIndex)));
				numberOfStreams -= 1;
				lastIndex -= 1;
			}
		}
	}
}
