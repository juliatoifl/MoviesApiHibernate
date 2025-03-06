package com.example.MoviesApiHibernate.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.MoviesApiHibernate.usecases.MeasurePerformance;

@RestController
@RequestMapping("/performance")
@RequiredArgsConstructor
public class PerformanceEndpoints {
  private final MeasurePerformance measurePerformance;

  @GetMapping("/insert")
  public ResponseEntity<Long> measureInsertPerformance() {
    long elapsedTime = measurePerformance.insert();
    return ResponseEntity.ok(elapsedTime);
  }
}
