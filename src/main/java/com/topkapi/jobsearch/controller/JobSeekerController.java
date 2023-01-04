package com.topkapi.jobsearch.controller;

import com.topkapi.jobsearch.dto.CreateJobSeekerDto;
import com.topkapi.jobsearch.dto.EditJobSeekerDto;
import com.topkapi.jobsearch.dto.JobSeekerDto;
import com.topkapi.jobsearch.service.JobSeekerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/jobseekers")
public class JobSeekerController {
    private final JobSeekerService jobSeekerService;

    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping
    public ResponseEntity<List<JobSeekerDto>> getList() {
        List<JobSeekerDto> jobSeekerDtos = this.jobSeekerService.getList();
        return ResponseEntity.ok(jobSeekerDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobSeekerDto> getById(@PathVariable("id") String id) {
        JobSeekerDto jobSeekerDto = this.jobSeekerService.getById(id);
        return ResponseEntity.ok(jobSeekerDto);
    }

    @PostMapping
    public ResponseEntity<JobSeekerDto> create(@RequestBody CreateJobSeekerDto createJobSeekerDto) {
        JobSeekerDto jobSeekerDto = this.jobSeekerService.create(createJobSeekerDto);
        return ResponseEntity.ok(jobSeekerDto);
    }

    @PutMapping
    public ResponseEntity<JobSeekerDto> edit(@RequestBody EditJobSeekerDto editJobSeekerDto) {
        JobSeekerDto jobSeekerDto = this.jobSeekerService.edit(editJobSeekerDto);
        return ResponseEntity.ok(jobSeekerDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
         this.jobSeekerService.delete(id);
    }
}
