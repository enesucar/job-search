package com.topkapi.jobsearch.service;

import com.topkapi.jobsearch.dto.*;
import com.topkapi.jobsearch.exception.EmailAlreadyExistsException;
import com.topkapi.jobsearch.exception.EntityNotFoundException;
import com.topkapi.jobsearch.mapper.JobMapper;
import com.topkapi.jobsearch.model.*;
import com.topkapi.jobsearch.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;
    private final JobMapper jobMapper;
    private final CityService cityService;
    private final CategoryService categoryService;
    private final PositionService positionService;
    private final EmployerService employerService;

    public JobService(JobRepository jobRepository,
                      JobMapper jobMapper,
                      CityService cityService,
                      CategoryService categoryService,
                      PositionService positionService,
                      EmployerService employerService) {
        this.jobRepository = jobRepository;
        this.jobMapper = jobMapper;
        this.cityService = cityService;
        this.categoryService = categoryService;
        this.positionService = positionService;
        this.employerService = employerService;
    }

     public List<JobDto> getList() {
        List<Job> jobs = this.jobRepository.findAll();
        return jobMapper.map(jobs);
     }

    public JobDto getById(String id) {
        Job job = findById(id);
        return jobMapper.map(job);
    }

    protected Job findById(String id) {
        Job job = this.jobRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Job is not found: " + id));
        return job;
    }

    public JobDto create(CreateJobDto createJobDto) {
//        if (checkIfEmailExistsForCreate(createJobSeekerDto.getEmail())) {
//            throw new EmailAlreadyExistsException("Email already exists: " + createJobSeekerDto.getEmail());
//        }

        Job job = this.jobMapper.map(createJobDto);
        job.setCreatedDate(LocalDateTime.now());

        City city = this.cityService.findById(createJobDto.getCityId());
        Category category = this.categoryService.findById(createJobDto.getCategoryId());
        Position position = this.positionService.findById(createJobDto.getPositionId());
        Employer employer = this.employerService.findById(createJobDto.getEmployerId());

        job.setCity(city);
        job.setCategory(category);
        job.setPosition(position);
        job.setEmployer(employer);
        job.setApplications(new ArrayList<Application>());

        Job createdJob =  this.jobRepository.save(job);
        return this.jobMapper.map(createdJob);
    }

    public JobDto edit(EditJobDto editJobDto) {
        Job job = this.findById(editJobDto.getId());
        Job editToJob = jobMapper.map(editJobDto);

        City city = this.cityService.findById(editJobDto.getCityId());
        Category category = this.categoryService.findById(editJobDto.getCategoryId());
        Position position = this.positionService.findById(editJobDto.getPositionId());
        Employer employer = this.employerService.findById(editJobDto.getEmployerId());

        editToJob.setCity(city);
        editToJob.setCategory(category);
        editToJob.setPosition(position);
        editToJob.setEmployer(employer);
        //TODO: Set applications

        editToJob.setCreatedDate(job.getCreatedDate());
        editToJob.setUpdatedDate(LocalDateTime.now());

        Job editedJob = this.jobRepository.save(editToJob);
        return this.jobMapper.map(editedJob);
    }

    public void delete(String id) {
        Job deleteToJob = this.findById(id);
        this.jobRepository.delete(deleteToJob);
    }
}
