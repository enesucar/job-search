package com.topkapi.jobsearch.repository;

import com.topkapi.jobsearch.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
}
