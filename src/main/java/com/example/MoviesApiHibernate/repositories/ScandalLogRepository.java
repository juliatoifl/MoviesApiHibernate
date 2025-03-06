package com.example.MoviesApiHibernate.repositories;

import com.example.MoviesApiHibernate.entities.ScandalLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScandalLogRepository extends JpaRepository<ScandalLog, Long> {
}

