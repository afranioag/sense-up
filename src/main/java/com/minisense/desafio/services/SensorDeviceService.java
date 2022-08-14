package com.minisense.desafio.services;

import com.minisense.desafio.dto.DataStreamDto;
import com.minisense.desafio.dto.SensorDataPublishDto;
import com.minisense.desafio.dto.SensorDeviceResDto;
import com.minisense.desafio.entities.*;
import com.minisense.desafio.exceptions.DatabaseException;
import com.minisense.desafio.exceptions.UserNotFoundException;
import com.minisense.desafio.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@Service
public class SensorDeviceService {
    private static Logger logger = LoggerFactory.getLogger(SensorDeviceService.class);
    @Autowired
    private SensorDeviceRepository deviceRepository;

    @Autowired
    private MeasurementUnitRepository unitRepository;

    @Autowired
    private DataStreamRepository streamRepository;

    @Autowired
    private SensorDataRepository dataRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public SensorDeviceResDto save(Long id, SensorDeviceResDto dto) {
        try {
            User user = userRepository.getOne(id);
            SensorDevice device = new SensorDevice();
            device.setLabel(dto.getLabel());
            device.setDescription(dto.getDescription());
            device.setUser(user);
            deviceRepository.save(device);

            user.getDevices().add(device);
            userRepository.save(user);
            return new SensorDeviceResDto(device);
        }
        catch (EntityNotFoundException e){
            throw new UserNotFoundException();
        }
    }

    @Transactional
    public DataStreamDto insertStream(Long id, DataStreamDto dto) {

        try {
            logger.info("Buscando sensorDevice: " + id);
            SensorDevice device = deviceRepository.getOne(id);

            logger.info("Buscando measurementUnit: " + dto.getUnitId());
            MeasurementUnit unit = unitRepository.getOne(dto.getUnitId());

            DataStream stream = new DataStream();
            stream.setLabel(dto.getLabel());
            stream.setUnit(unit);
            stream.setSensorDevice(device);
            streamRepository.save(stream);

            device.getStreams().add(stream);
            deviceRepository.save(device);
            return new DataStreamDto(stream);
        }
        catch (EntityNotFoundException e) {
            logger.error("Entity not found. SensorDeviceId {}, measurementUnitId {}", id, dto.getUnitId());
            throw new UserNotFoundException();
        }
        catch (DataIntegrityViolationException e) {
            logger.error("Integrity violation. SensorDeviceId {}, measurementUnitId {}", id, dto.getUnitId());
            throw new DatabaseException();
        }
    }

    @Transactional
    public SensorDataPublishDto insertMeasurement(Long streamId, SensorDataPublishDto dto) {
        try {
            DataStream stream = streamRepository.getOne(streamId);
            SensorData data = new SensorData();

            data.setStreams(stream);
            data.setTimestamp(new Date(dto.getTimestamp()));
            data.setValueSensor(dto.getValue());
            data.setUnit(stream.getUnit());
            dataRepository.save(data);

            stream.getCollects().add(data);
            dataRepository.save(data);
            return new SensorDataPublishDto(data);
        }
        catch (EntityNotFoundException e){
            throw new UserNotFoundException();
        }
    }


}
