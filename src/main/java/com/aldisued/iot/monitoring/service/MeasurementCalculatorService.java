package com.aldisued.iot.monitoring.service;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementCalculatorService {

  public List<Double> filterByAverageDeviation(List<Double> values, Double deviation) {
    validateDeviation(deviation);

    Double average = values.stream().reduce(Double::sum).map(sum -> sum / values.size()).orElse(0.0d);
    Double rangeMin = average - deviation * average;
    Double rangeMax = average + deviation * average;

    return values.stream()
            .filter(value -> rangeMin.compareTo(value) <= 0 && rangeMax.compareTo(value) >= 0)
            .toList();
  }

  public List<Double> getMovingAverage(List<Double> data, int windowSize) {
    // TODO: Task 10
    return List.of();
  }

  private void validateDeviation(Double deviation) {
    if (deviation < 0.0 || deviation > 1.0) {
      throw new IllegalArgumentException("Deviation must be between 0.0 and 1.0");
    }
  }

}
