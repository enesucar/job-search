package com.topkapi.jobsearch.service;

import com.topkapi.jobsearch.dto.ApplicationDto;
import com.topkapi.jobsearch.dto.CreateApplicationDto;
import com.topkapi.jobsearch.dto.CreateEmployerDto;
import com.topkapi.jobsearch.dto.EmployerDto;
import com.topkapi.jobsearch.exception.ApplicationAlreadyExistsException;
import com.topkapi.jobsearch.exception.EmailAlreadyExistsException;
import com.topkapi.jobsearch.exception.EntityNotFoundException;
import com.topkapi.jobsearch.mapper.ApplicationMapper;
import com.topkapi.jobsearch.model.Application;
import com.topkapi.jobsearch.model.Employer;
import com.topkapi.jobsearch.model.Job;
import com.topkapi.jobsearch.model.JobSeeker;
import com.topkapi.jobsearch.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;
    private final JobService jobService;
    private final JobSeekerService jobSeekerService;

    public ApplicationService(ApplicationRepository applicationRepository,
                              ApplicationMapper applicationMapper,
                              JobService jobService,
                              JobSeekerService jobSeekerService) {
        this.applicationRepository = applicationRepository;
        this.applicationMapper = applicationMapper;
        this.jobService = jobService;
        this.jobSeekerService = jobSeekerService;
    }

    public List<ApplicationDto> getList() {
        List<Application> applications = this.applicationRepository.findAll();
        return applicationMapper.map(applications);
    }

    public ApplicationDto getById(String id) {
        Application application = findById(id);
        return applicationMapper.map(application);
    }

    protected Application findById(String id) {
        Application application =  this.applicationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Application is not found: " + id));
        return application;
    }

    public ApplicationDto create(CreateApplicationDto createApplicationDto) {
        if (checkIfApplicationExistsByJobIdAndJobSeekerId(createApplicationDto.getJobId(), createApplicationDto.getJobSeekerId())) {
            throw new ApplicationAlreadyExistsException("Application already exists for this job seeker. Job id: " +
                    createApplicationDto.getJobSeekerId() + " and Job Seeker id: " + createApplicationDto.getJobSeekerId());
        }

        Application application = this.applicationMapper.map(createApplicationDto);
        JobSeeker jobSeeker = this.jobSeekerService.findById(createApplicationDto.getJobSeekerId());
        Job job = this.jobService.findById(createApplicationDto.getJobId());

        application.setJobSeeker(jobSeeker);
        application.setJob(job);
        application.setCreatedDate(LocalDateTime.now());

        Application createdApplication =  this.applicationRepository.save(application);
        return this.applicationMapper.map(createdApplication);
    }

    public void delete(String id) {
        Application deleteToApplication = this.findById(id);
        this.applicationRepository.delete(deleteToApplication);
    }

    private boolean checkIfApplicationExistsByJobIdAndJobSeekerId(String jobId, String jobSeekerId) {
        System.out.println(this.applicationRepository.existsByJobIdAndJobSeekerId(jobId, jobSeekerId));
        return this.applicationRepository.existsByJobIdAndJobSeekerId(jobId, jobSeekerId);
    }
}