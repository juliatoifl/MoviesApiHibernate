package com.example.MoviesApiHibernate.repositories;

import com.example.MoviesApiHibernate.entities.Genre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
  Optional<Genre> findByName(String name);
}
