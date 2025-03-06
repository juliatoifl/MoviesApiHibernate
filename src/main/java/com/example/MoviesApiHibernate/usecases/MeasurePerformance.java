package com.example.MoviesApiHibernate.usecases;

import com.example.MoviesApiHibernate.entities.Actor;
import com.example.MoviesApiHibernate.repositories.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MeasurePerformance {
  private final ActorRepository actorRepository;

  @Transactional
  public long insert() {
    long start = System.currentTimeMillis();

    List<Actor> actors = new ArrayList<>();
    for (int i = 0; i < 10000; i++) {
      actors.add(Actor.builder()
          .firstName("Actor" + i)
          .lastName("Test")
          .dateOfBirth(LocalDate.of(1980, 1, 1))
          .build());
    }
    actorRepository.saveAll(actors);

    return System.currentTimeMillis() - start;
  }
}