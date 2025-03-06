package com.example.MoviesApiHibernate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AcademyAwardNomination {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int year;
  private String category;
  private boolean won;

  @ManyToOne
  @JoinColumn(name = "actor_id", nullable = false)
  private Actor actor;

  @ManyToOne
  @JoinColumn(name = "movie_id", nullable = false)
  private Movie movie;
}

