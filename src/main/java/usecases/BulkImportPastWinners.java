package usecases;

import entities.AcademyAwardNomination;
import repositories.AcademyAwardNominationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BulkImportPastWinners {
  private final AcademyAwardNominationRepository nominationRepository;

  @Transactional
  public void execute(List<AcademyAwardNomination> pastWinners) {
    nominationRepository.saveAll(pastWinners);
  }
}

