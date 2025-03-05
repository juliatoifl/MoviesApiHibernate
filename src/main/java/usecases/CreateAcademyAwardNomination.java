package usecases;

import entities.AcademyAwardNomination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.AcademyAwardNominationRepository;

@Service
public class CreateAcademyAwardNomination {
  private final AcademyAwardNominationRepository nominationRepository;

  public CreateAcademyAwardNomination(AcademyAwardNominationRepository nominationRepository) {
    this.nominationRepository = nominationRepository;
  }

  @Transactional
  public void execute(AcademyAwardNomination nomination) {
    nominationRepository.save(nomination);
  }
}
