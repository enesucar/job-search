package com.topkapi.jobsearch.service;

import com.topkapi.jobsearch.dto.CategoryDto;
import com.topkapi.jobsearch.dto.CityDto;
import com.topkapi.jobsearch.exception.EntityNotFoundException;
import com.topkapi.jobsearch.mapper.CityMapper;
import com.topkapi.jobsearch.model.Category;
import com.topkapi.jobsearch.model.City;
import com.topkapi.jobsearch.repository.CityRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public CityService(CityRepository cityRepository,
                       CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    public List<CityDto> getList() {
        List<City> cities = this.cityRepository.findAll();
        return cityMapper.map(cities);
    }

    public CityDto getById(String id) {
        City City = findById(id);
        return cityMapper.map(City);
    }

    protected City findById(String id) {
        City city =  this.cityRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("City is not found: " + id));
        return city;
    }
}
