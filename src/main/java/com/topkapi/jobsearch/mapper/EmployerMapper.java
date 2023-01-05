package com.topkapi.jobsearch.mapper;

import com.topkapi.jobsearch.dto.CreateEmployerDto;
import com.topkapi.jobsearch.dto.EditEmployerDto;
import com.topkapi.jobsearch.dto.EmployerDto;
import com.topkapi.jobsearch.model.Employer;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployerMapper {
    EmployerDto map(Employer employer);
    List<EmployerDto> map(List<Employer> employers);
    Employer map(CreateEmployerDto createEmployerDto);
    Employer map(EditEmployerDto editEmployerDto);
}