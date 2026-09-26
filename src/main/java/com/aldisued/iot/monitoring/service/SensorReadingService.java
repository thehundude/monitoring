package com.aldisued.iot.monitoring.service;

import com.aldisued.iot.monitoring.converter.SensorReadingConverter;
import com.aldisued.iot.monitoring.dto.SensorReadingDto;
import com.aldisued.iot.monitoring.entity.SensorReading;
import com.aldisued.iot.monitoring.repository.SensorReadingRepository;
import com.aldisued.iot.monitoring.repository.SensorRepository;
import org.springframework.stereotype.Service;

@Service
public class SensorReadingService {

  private final SensorReadingRepository sensorReadingRepository;
  private final SensorRepository sensorRepository;
  private final SensorReadingConverter sensorReadingConverter;

  public SensorReadingService(SensorReadingRepository sensorReadingRepository,
                              SensorRepository sensorRepository, SensorReadingConverter sensorReadingConverter) {
    this.sensorReadingRepository = sensorReadingRepository;
    this.sensorRepository = sensorRepository;
    this.sensorReadingConverter = sensorReadingConverter;
  }

  public SensorReading saveSensorReading(SensorReadingDto sensorReadingDto) {
    return sensorReadingRepository.save(sensorReadingConverter.convertToEntity(sensorReadingDto));
  }

}
