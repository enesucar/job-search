package com.topkapi.jobsearch.mapper;

import com.topkapi.jobsearch.dto.*;
import com.topkapi.jobsearch.model.Application;
import com.topkapi.jobsearch.model.JobSeeker;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    ApplicationDto map(Application application);
    List<ApplicationDto> map(List<Application> applications);
    Application map(CreateApplicationDto createApplicationDto);
   // Employer map(EditEmployerDto editEmployerDto);

    @AfterMapping
    default void setFullName(@MappingTarget ApplicationJobSeekerDto applicationJobSeekerDto, JobSeeker jobSeeker) {
        applicationJobSeekerDto.setFullName(jobSeeker.getFirstName() + " " + jobSeeker.getLastName());
    }
}
