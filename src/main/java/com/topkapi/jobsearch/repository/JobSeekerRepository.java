package com.topkapi.jobsearch.repository;

import com.topkapi.jobsearch.model.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, String> {
}
