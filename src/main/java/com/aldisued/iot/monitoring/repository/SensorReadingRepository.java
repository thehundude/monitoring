package com.aldisued.iot.monitoring.repository;

import com.aldisued.iot.monitoring.entity.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SensorReadingRepository extends JpaRepository<SensorReading, String> {
    @Query("""
            SELECT reading FROM SensorReading reading
            WHERE reading.timestamp >= :from AND reading.timestamp <= :to
            AND reading.sensor.type = 'TEMPERATURE'""")
    List<SensorReading> findAllTemperatureReadingInPeriod(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);
}
