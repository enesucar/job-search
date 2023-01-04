package com.topkapi.jobsearch.mapper;

import com.topkapi.jobsearch.dto.CategoryDto;
import com.topkapi.jobsearch.dto.CityDto;
import com.topkapi.jobsearch.model.Category;
import com.topkapi.jobsearch.model.City;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto map(Category category);
    List<CategoryDto> map(List<Category> categories);
}

