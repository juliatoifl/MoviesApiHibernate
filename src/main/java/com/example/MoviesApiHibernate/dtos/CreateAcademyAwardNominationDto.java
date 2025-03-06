package com.example.MoviesApiHibernate.dtos;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAcademyAwardNominationDto {
  private int year;
  private String category;
  private boolean won;

  private String actorFirstName;
  private String actorLastName;
  private LocalDate actorDateOfBirth;

  private String movieTitle;
  private int releaseYear;
  private String genre;
}

