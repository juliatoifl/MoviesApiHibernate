package com.example.MoviesApiHibernate.usecases;

import com.example.MoviesApiHibernate.entities.Actor;
import com.example.MoviesApiHibernate.repositories.ActorRepository;
import com.example.MoviesApiHibernate.repositories.MovieRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OptimizedMeasurePerformance {
  private final EntityManagerFactory entityManagerFactory;

  @Transactional
  public long insert() {
    long start = System.currentTimeMillis();
    int batchSize = 50;

    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();

    for (int i = 0; i < 10000; i++) {
      Actor actor = Actor.builder()
          .firstName("Actor" + i)
          .lastName("Test")
          .dateOfBirth(LocalDate.of(1980, 1, 1))
          .build();

      entityManager.persist(actor);

      if (i % batchSize == 0) {
        entityManager.flush();
        entityManager.clear();
      }
    }

    entityManager.getTransaction().commit();
    entityManager.close();

    return System.currentTimeMillis() - start;
  }
}