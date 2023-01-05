package com.topkapi.jobsearch.repository;

import com.topkapi.jobsearch.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, String> {
}
