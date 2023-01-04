package com.topkapi.jobsearch.repository;

import com.topkapi.jobsearch.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, String> {
    boolean existsByJobIdAndJobSeekerId(String jobId, String jobSeekerId);
    List<Application> getByJobSeeker_Id(String id);
}
