package com.aldisued.iot.monitoring.converter;

import com.aldisued.iot.monitoring.dto.AlertDto;
import com.aldisued.iot.monitoring.entity.Alert;
import org.springframework.stereotype.Component;

@Component
public class AlertConverter {
    public AlertDto convertToDto(Alert alert) {
        return new AlertDto(
                alert.getSensor().getId(),
                alert.getMessage(),
                alert.getTimestamp()
        );
    }
}
