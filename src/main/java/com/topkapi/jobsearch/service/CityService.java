package com.topkapi.jobsearch.service;

import com.topkapi.jobsearch.exception.EntityNotFoundException;
import com.topkapi.jobsearch.model.City;
import com.topkapi.jobsearch.repository.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    protected City findById(String id) {
        City city =  this.cityRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("City is not found: " + id));
        return city;
    }
}
