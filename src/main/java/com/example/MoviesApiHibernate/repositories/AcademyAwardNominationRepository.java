package com.example.MoviesApiHibernate.repositories;

import com.example.MoviesApiHibernate.entities.AcademyAwardNomination;
import com.example.MoviesApiHibernate.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyAwardNominationRepository extends JpaRepository<AcademyAwardNomination, Long> {
  void deleteAllByActor(Actor actor);
}

