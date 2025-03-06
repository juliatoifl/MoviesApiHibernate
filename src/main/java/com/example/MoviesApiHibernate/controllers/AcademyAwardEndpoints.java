package com.example.MoviesApiHibernate.controllers;

import com.example.MoviesApiHibernate.dtos.CreateAcademyAwardNominationDto;
import com.example.MoviesApiHibernate.dtos.ReactToScandalDto;
import com.example.MoviesApiHibernate.entities.AcademyAwardNomination;
import com.example.MoviesApiHibernate.usecases.BulkImportPastWinners;
import com.example.MoviesApiHibernate.usecases.CreateAcademyAwardNomination;
import com.example.MoviesApiHibernate.usecases.ReactToScandal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/awards")
@RequiredArgsConstructor
@Tag(name = "Academy Awards", description = "Endpoints for managing Academy Awards")
public class AcademyAwardEndpoints {

  private final CreateAcademyAwardNomination createAcademyAwardNomination;
  private final ReactToScandal reactToScandal;
  private final BulkImportPastWinners bulkImportPastWinners;

  @PostMapping("/nomination")
  @Operation(summary = "Create an Academy Award nomination")
  public ResponseEntity<Void> createNomination(
      @RequestBody CreateAcademyAwardNominationDto nominationDto) {
    createAcademyAwardNomination.execute(nominationDto);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/scandal")
  @Operation(summary = "React to a scandal by removing an actor's nomination")
  public ResponseEntity<Void> reactToScandal(@RequestBody ReactToScandalDto scandalDto) {
    reactToScandal.execute(scandalDto.getActorId(), scandalDto.getReason());
    return ResponseEntity.ok().build();
  }

  @PostMapping("/bulk-import-past-winners")
  @Operation(summary = "Bulk import past Academy Award winners")
  public ResponseEntity<Void> bulkImportPastWinners(
      @RequestBody List<CreateAcademyAwardNominationDto> nominationsDtos) {
    bulkImportPastWinners.execute(nominationsDtos);
    return ResponseEntity.ok().build();
  }
}
