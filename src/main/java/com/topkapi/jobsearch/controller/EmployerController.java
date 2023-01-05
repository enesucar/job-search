package com.topkapi.jobsearch.controller;

import com.topkapi.jobsearch.dto.*;
import com.topkapi.jobsearch.service.EmployerService;
import com.topkapi.jobsearch.service.JobService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/employers")
public class EmployerController {
    private final EmployerService employerService;
    private final JobService jobService;

    public EmployerController(EmployerService employerService,
                              JobService jobService) {
        this.employerService = employerService;
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<EmployerDto>> getList() {
        List<EmployerDto> employerDtos = this.employerService.getList();
        return ResponseEntity.ok(employerDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployerDto> getById(@PathVariable("id") String id) {
        EmployerDto employerDto = this.employerService.getById(id);
        return ResponseEntity.ok(employerDto);
    }

    @GetMapping("/{id}/jobs")
    public ResponseEntity<List<JobDto>> getJobListByEmployerId(@PathVariable("id") String id) {
        List<JobDto> jobDtos = this.jobService.getListByEmployerId(id);
        return ResponseEntity.ok(jobDtos);
    }

    @PostMapping
    public ResponseEntity<EmployerDto> create(@RequestBody @Valid CreateEmployerDto createEmployerDto) {
        EmployerDto employerDto = this.employerService.create(createEmployerDto);
        return ResponseEntity.ok(employerDto);
    }

    @PutMapping
    public ResponseEntity<EmployerDto> edit(@RequestBody @Valid EditEmployerDto editEmployerDto) {
        EmployerDto employerDto = this.employerService.edit(editEmployerDto);
        return ResponseEntity.ok(employerDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.employerService.delete(id);
    }
}
