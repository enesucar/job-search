package com.topkapi.jobsearch.repository;

import com.topkapi.jobsearch.model.Application;
import com.topkapi.jobsearch.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
    List<Job> getByEmployer_Id(String id);
}
