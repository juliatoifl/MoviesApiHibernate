package com.example.MoviesApiHibernate.usecases;

import com.example.MoviesApiHibernate.entities.AcademyAwardNomination;
import com.example.MoviesApiHibernate.entities.Actor;
import com.example.MoviesApiHibernate.entities.Genre;
import com.example.MoviesApiHibernate.entities.Movie;
import com.example.MoviesApiHibernate.repositories.AcademyAwardNominationRepository;
import com.example.MoviesApiHibernate.repositories.ActorRepository;
import com.example.MoviesApiHibernate.repositories.GenreRepository;
import com.example.MoviesApiHibernate.repositories.MovieRepository;
import com.example.MoviesApiHibernate.dtos.CreateAcademyAwardNominationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateAcademyAwardNomination {
  private final AcademyAwardNominationRepository nominationRepository;
  private final ActorRepository actorRepository;
  private final MovieRepository movieRepository;
  private final GenreRepository genreRepository;

  @Transactional
  public void execute(CreateAcademyAwardNominationDto dto) {
    var existingGenre = genreRepository.findByName(dto.getGenre())
        .orElseGet(() -> {
          Genre newGenre = new Genre();
          newGenre.setName(dto.getGenre());
          return genreRepository.save(newGenre);
        });

    var existingActor = actorRepository.findByFirstNameAndLastNameAndDateOfBirth(
        dto.getActorFirstName(), dto.getActorLastName(), dto.getActorDateOfBirth()
    ).orElseGet(() -> {
      Actor newActor = new Actor();
      newActor.setFirstName(dto.getActorFirstName());
      newActor.setLastName(dto.getActorLastName());
      newActor.setDateOfBirth(dto.getActorDateOfBirth());
      return actorRepository.save(newActor);
    });

    var existingMovie = movieRepository.findByTitleAndReleaseYear(
        dto.getMovieTitle(), dto.getReleaseYear()
    ).orElseGet(() -> {
      Movie newMovie = new Movie();
      newMovie.setTitle(dto.getMovieTitle());
      newMovie.setReleaseYear(dto.getReleaseYear());
      newMovie.setGenre(existingGenre);
      return movieRepository.save(newMovie);
    });

    if (!existingMovie.getActors().contains(existingActor)) {
      existingMovie.getActors().add(existingActor);
      existingActor.getMovies().add(existingMovie);
      movieRepository.save(existingMovie);
    }

    AcademyAwardNomination nomination = new AcademyAwardNomination();
    nomination.setYear(dto.getYear());
    nomination.setCategory(dto.getCategory());
    nomination.setWon(dto.isWon());
    nomination.setActor(existingActor);
    nomination.setMovie(existingMovie);

    nominationRepository.save(nomination);
  }
}
