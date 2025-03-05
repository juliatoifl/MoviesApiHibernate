package entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Movie {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private int releaseYear;

  @ManyToOne
  @JoinColumn(name = "genre_id", nullable = false)
  private Genre genre;
}
