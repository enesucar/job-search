package com.topkapi.jobsearch.repository;

import com.topkapi.jobsearch.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, String> {
    boolean existsById(String id);
    boolean existsByEmail(String email);
}
