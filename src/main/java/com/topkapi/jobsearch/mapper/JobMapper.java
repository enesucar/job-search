package com.topkapi.jobsearch.mapper;

import com.topkapi.jobsearch.dto.*;
import com.topkapi.jobsearch.model.Employer;
import com.topkapi.jobsearch.model.Job;
import com.topkapi.jobsearch.model.JobSeeker;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobMapper {
    JobDto map(Job job);
    List<JobDto> map(List<Job> jobs);
    Job map(CreateJobDto createJobDto);
    Job map(EditJobDto editJobDto);

    @AfterMapping
    default void setNumberOfApplications(@MappingTarget JobDto jobDto, Job job) {
        jobDto.setNumberOfApplications(job.getApplications().size());
    }

    @AfterMapping
    default void setCategoryName(@MappingTarget JobDto jobDto, Job job) {
        jobDto.setCategoryName(job.getCategory().getName());
    }

    @AfterMapping
    default void setPositionName(@MappingTarget JobDto jobDto, Job job) {
        jobDto.setPositionName(job.getPosition().getName());
    }

    @AfterMapping
    default void setCityName(@MappingTarget JobDto jobDto, Job job) {
        jobDto.setCityName(job.getCity().getName());
    }
}
