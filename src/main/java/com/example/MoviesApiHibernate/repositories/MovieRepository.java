package com.example.MoviesApiHibernate.repositories;

import com.example.MoviesApiHibernate.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
  Optional<Movie> findByTitleAndReleaseYear(String title, int releaseYear);
}
