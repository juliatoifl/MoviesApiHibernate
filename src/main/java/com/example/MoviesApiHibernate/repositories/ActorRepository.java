package com.example.MoviesApiHibernate.repositories;

import com.example.MoviesApiHibernate.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
  Optional<Actor> findByFirstNameAndLastNameAndDateOfBirth(String firstName, String lastName, LocalDate dateOfBirth);
}
