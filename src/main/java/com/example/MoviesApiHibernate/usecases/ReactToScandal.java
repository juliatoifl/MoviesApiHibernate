package com.example.MoviesApiHibernate.usecases;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import com.example.MoviesApiHibernate.entities.ScandalLog;
import com.example.MoviesApiHibernate.repositories.ScandalLogRepository;
import com.example.MoviesApiHibernate.repositories.AcademyAwardNominationRepository;
import com.example.MoviesApiHibernate.repositories.ActorRepository;

@RequiredArgsConstructor
@Service
public class ReactToScandal {
  private final ScandalLogRepository scandalLogRepository;
  private final AcademyAwardNominationRepository nominationRepository;
  private final ActorRepository actorRepository;

  @Transactional
  public void execute(Long actorId, String reason) {
    var actor = actorRepository.findById(actorId).orElseThrow();

    ScandalLog scandalLog = ScandalLog.builder()
        .actorFirstName(actor.getFirstName())
        .actorLastName(actor.getLastName())
        .reason(reason)
        .date(LocalDateTime.now())
        .build();

    scandalLogRepository.save(scandalLog);
    nominationRepository.deleteAllByActor(actor);
    actorRepository.delete(actor);
  }
}
