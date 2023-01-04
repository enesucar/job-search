package com.topkapi.jobsearch.repository;

import com.topkapi.jobsearch.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, String> {
    boolean existsByJobIdAndJobSeekerId(String jobId, String jobSeekerId);
}
