package com.topkapi.jobsearch.controller;

import com.topkapi.jobsearch.dto.ApplicationDto;
import com.topkapi.jobsearch.dto.PositionDto;
import com.topkapi.jobsearch.service.PositionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/positions")
public class PositionController {
    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public ResponseEntity<List<PositionDto>> getList() {
        List<PositionDto> positionDtos = this.positionService.getList();
        return ResponseEntity.ok(positionDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PositionDto> getById(@PathVariable("id") String id) {
        PositionDto positionDto = this.positionService.getById(id);
        return ResponseEntity.ok(positionDto);
    }
}
