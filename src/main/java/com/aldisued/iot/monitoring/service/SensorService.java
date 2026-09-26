package com.aldisued.iot.monitoring.service;

import com.aldisued.iot.monitoring.dto.SensorDto;
import com.aldisued.iot.monitoring.entity.Sensor;
import com.aldisued.iot.monitoring.repository.SensorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SensorService {

  private final SensorRepository sensorRepository;

  public SensorService(SensorRepository sensorRepository) {
    this.sensorRepository = sensorRepository;
  }

  public ResponseEntity<Sensor> saveSensor(SensorDto sensor) {
    if (!sensorHasName(sensor)) {
      return ResponseEntity.badRequest().build();
    }

    if (!sensorNameUnique(sensor)) {
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    Sensor savedSensor = sensorRepository.save(new Sensor(
            sensor.name(),
            sensor.type()
    ));

    return ResponseEntity.ok(savedSensor);
  }

  private boolean sensorHasName(SensorDto sensor) {
    return StringUtils.hasText(sensor.name());
  }

  private boolean sensorNameUnique(SensorDto sensor) {
    return sensorRepository.findByName(sensor.name()).isEmpty();
  }
}
