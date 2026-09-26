package com.aldisued.iot.monitoring.converter;

import com.aldisued.iot.monitoring.dto.SensorReadingDto;
import com.aldisued.iot.monitoring.entity.Sensor;
import com.aldisued.iot.monitoring.entity.SensorReading;
import com.aldisued.iot.monitoring.repository.SensorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SensorReadingConverter {

    private final SensorRepository sensorRepository;

    public SensorReadingConverter(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public SensorReading convertToEntity(SensorReadingDto dto) {
        Sensor sensor = sensorRepository.findById(dto.sensorId())
                .orElseThrow(() -> new EntityNotFoundException("Sensor with id " + dto.sensorId() + " not found"));

        return new SensorReading(
                dto.value(),
                dto.timestamp(),
                sensor
        );
    }
}
