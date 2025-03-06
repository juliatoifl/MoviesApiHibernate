package com.example.MoviesApiHibernate.controllers;

import com.example.MoviesApiHibernate.usecases.OptimizedMeasurePerformance;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.MoviesApiHibernate.usecases.MeasurePerformance;

@RestController
@RequestMapping("/performance")
@RequiredArgsConstructor
public class PerformanceEndpoints {
  private final MeasurePerformance measurePerformance;
  private final OptimizedMeasurePerformance optimizedMeasurePerformance;

  @GetMapping("/insert")
  public ResponseEntity<Long> measureInsertPerformance() {
    long elapsedTime = measurePerformance.insert();
    return ResponseEntity.ok(elapsedTime);
  }

  @GetMapping("/insert-optimized")
  public ResponseEntity<Long> measureOptimizedInsertPerformance() {
    long elapsedTime = optimizedMeasurePerformance.insert();
    return ResponseEntity.ok(elapsedTime);
  }
}
