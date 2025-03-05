package usecases;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import entities.ScandalLog;
import repositories.ScandalLogRepository;
import repositories.AcademyAwardNominationRepository;
import repositories.ActorRepository;

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
        .build();

    scandalLogRepository.save(scandalLog);
    nominationRepository.deleteAllByActor(actor);
    actorRepository.delete(actor);
  }
}
