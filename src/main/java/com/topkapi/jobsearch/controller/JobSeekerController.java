package com.topkapi.jobsearch.controller;

import com.topkapi.jobsearch.dto.*;
import com.topkapi.jobsearch.service.ApplicationService;
import com.topkapi.jobsearch.service.JobSeekerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/jobseekers")
public class JobSeekerController {
    private final JobSeekerService jobSeekerService;
    private final ApplicationService applicationService;

    public JobSeekerController(JobSeekerService jobSeekerService,
                               ApplicationService applicationService) {
        this.jobSeekerService = jobSeekerService;
        this.applicationService = applicationService;
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

    @GetMapping("/{id}/applications")
    public ResponseEntity<List<ApplicationDto>> getApplicationListByJobSeekerId(@PathVariable("id") String id) {
        List<ApplicationDto> applicationDtos = this.applicationService.getListByJobSeekerId(id);
        return ResponseEntity.ok(applicationDtos);
    }

    @PostMapping
    public ResponseEntity<JobSeekerDto> create(@RequestBody @Valid CreateJobSeekerDto createJobSeekerDto) {
        JobSeekerDto jobSeekerDto = this.jobSeekerService.create(createJobSeekerDto);
        return ResponseEntity.ok(jobSeekerDto);
    }

    @PutMapping
    public ResponseEntity<JobSeekerDto> edit(@RequestBody @Valid EditJobSeekerDto editJobSeekerDto) {
        JobSeekerDto jobSeekerDto = this.jobSeekerService.edit(editJobSeekerDto);
        return ResponseEntity.ok(jobSeekerDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
         this.jobSeekerService.delete(id);
    }
}
