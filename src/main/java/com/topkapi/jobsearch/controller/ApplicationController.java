package com.topkapi.jobsearch.controller;

import com.topkapi.jobsearch.dto.*;
import com.topkapi.jobsearch.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public ResponseEntity<List<ApplicationDto>> getList() {
        List<ApplicationDto> applicationDtos = this.applicationService.getList();
        return ResponseEntity.ok(applicationDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationDto> getById(@PathVariable("id") String id) {
        ApplicationDto applicationDto = this.applicationService.getById(id);
        return ResponseEntity.ok(applicationDto);
    }

    @PostMapping
    public ResponseEntity<ApplicationDto> create(@RequestBody CreateApplicationDto createApplicationDto) {
        ApplicationDto applicationDto = this.applicationService.create(createApplicationDto);
        return ResponseEntity.ok(applicationDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.applicationService.delete(id);
    }
}
