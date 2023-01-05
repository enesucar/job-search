package com.topkapi.jobsearch.controller;

import com.topkapi.jobsearch.dto.CategoryDto;
import com.topkapi.jobsearch.dto.CityDto;
import com.topkapi.jobsearch.model.City;
import com.topkapi.jobsearch.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/cities")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> getList() {
        List<CityDto> cityDtos = this.cityService.getList();
        return ResponseEntity.ok(cityDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDto> getById(@PathVariable("id") String id) {
        CityDto cityDto = this.cityService.getById(id);
        return ResponseEntity.ok(cityDto);
    }
}
