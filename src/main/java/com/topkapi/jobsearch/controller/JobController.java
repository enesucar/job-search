package com.topkapi.jobsearch.controller;

import com.topkapi.jobsearch.dto.*;
import com.topkapi.jobsearch.model.Job;
import com.topkapi.jobsearch.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobDto>> getList() {
        List<JobDto> jobDtos = this.jobService.getList();
        return ResponseEntity.ok(jobDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDto> getById(@PathVariable("id") String id) {
        JobDto jobDto = this.jobService.getById(id);
        return ResponseEntity.ok(jobDto);
    }

    @PostMapping
    public ResponseEntity<JobDto> create(@RequestBody CreateJobDto createJobDto) {
        JobDto jobDto = this.jobService.create(createJobDto);
        return ResponseEntity.ok(jobDto);
    }

    @PutMapping
    public ResponseEntity<JobDto> edit(@RequestBody EditJobDto editJobDto) {
        JobDto jobDto = this.jobService.edit(editJobDto);
        return ResponseEntity.ok(jobDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.jobService.delete(id);
    }
}
