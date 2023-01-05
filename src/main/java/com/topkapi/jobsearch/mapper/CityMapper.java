package com.topkapi.jobsearch.mapper;

import com.topkapi.jobsearch.dto.CityDto;
import com.topkapi.jobsearch.model.City;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityDto map(City city);
    List<CityDto> map(List<City> cities);
}
