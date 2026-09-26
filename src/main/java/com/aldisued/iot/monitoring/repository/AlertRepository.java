package com.aldisued.iot.monitoring.repository;

import com.aldisued.iot.monitoring.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface AlertRepository extends JpaRepository<Alert, String> {
    @Query("""
            SELECT a FROM Alert a
            WHERE a.sensor.id = :sensorId
            ORDER BY a.timestamp desc
            LIMIT 1""")
    Optional<Alert> findLatestAlertBySensorId(@Param("sensorId") UUID sensorId);
}
