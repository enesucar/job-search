package com.topkapi.jobsearch.mapper;

import com.topkapi.jobsearch.dto.CreateJobSeekerDto;
import com.topkapi.jobsearch.dto.EditJobSeekerDto;
import com.topkapi.jobsearch.dto.JobSeekerDto;
import com.topkapi.jobsearch.model.JobSeeker;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobSeekerMapper {
    JobSeekerDto map(JobSeeker jobSeeker);
    List<JobSeekerDto> map(List<JobSeeker> jobSeekers);
    JobSeeker map(CreateJobSeekerDto jobSeeker);
    JobSeeker map(EditJobSeekerDto jobSeeker);

    @AfterMapping
    default void setFullName(@MappingTarget JobSeekerDto bookDTO, JobSeeker jobSeeker) {
        bookDTO.setFullName(jobSeeker.getFirstName() + " " + jobSeeker.getLastName());
    }
}
