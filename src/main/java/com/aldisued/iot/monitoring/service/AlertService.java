package com.aldisued.iot.monitoring.service;

import com.aldisued.iot.monitoring.converter.AlertConverter;
import com.aldisued.iot.monitoring.dto.AlertDto;
import com.aldisued.iot.monitoring.entity.Alert;
import com.aldisued.iot.monitoring.repository.AlertRepository;
import com.aldisued.iot.monitoring.repository.SensorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AlertService {
    private final AlertRepository alertRepository;
    private final SensorRepository sensorRepository;
    private final AlertConverter alertConverter;
    private final KafkaTemplate<String, AlertDto> kafkaTemplate;

    public AlertService(AlertRepository alertRepository,
                        SensorRepository sensorRepository,
                        AlertConverter alertConverter,
                        KafkaTemplate<String, AlertDto> kafkaTemplate) {
        this.alertRepository = alertRepository;
        this.sensorRepository = sensorRepository;
        this.alertConverter = alertConverter;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Alert saveAlert(AlertDto alertDto) {
        // TODO: Task 6
        return null;
    }

  public ResponseEntity<AlertDto> findLastAlertBySensorId(UUID sensorId) {
    return alertRepository.findLatestAlertBySensorId(sensorId)
            .map(alertConverter::convertToDto)
            .map(dto -> ResponseEntity.ok().body(dto))
            .orElse(ResponseEntity.notFound().build());
  }
}
