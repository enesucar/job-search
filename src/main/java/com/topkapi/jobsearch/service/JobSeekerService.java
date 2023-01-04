package com.topkapi.jobsearch.service;

import com.topkapi.jobsearch.dto.CreateJobSeekerDto;
import com.topkapi.jobsearch.dto.EditJobSeekerDto;
import com.topkapi.jobsearch.dto.JobSeekerDto;
import com.topkapi.jobsearch.exception.EmailAlreadyExistsException;
import com.topkapi.jobsearch.exception.EntityNotFoundException;
import com.topkapi.jobsearch.mapper.JobSeekerMapper;
import com.topkapi.jobsearch.model.City;
import com.topkapi.jobsearch.model.JobSeeker;
import com.topkapi.jobsearch.repository.JobSeekerRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobSeekerService {
    private final JobSeekerRepository jobSeekerRepository;
    private final JobSeekerMapper jobSeekerMapper;
    private final CityService cityService;

    public JobSeekerService(JobSeekerRepository jobSeekerRepository,
                            JobSeekerMapper jobSeekerMapper,
                            CityService cityService) {
        this.jobSeekerRepository = jobSeekerRepository;
        this.jobSeekerMapper = jobSeekerMapper;
        this.cityService = cityService;
    }

    @Cacheable(cacheNames = "jobSeekersDto")
    public List<JobSeekerDto> getList() {
        List<JobSeeker> jobSeekers = this.jobSeekerRepository.findAll();

        List<JobSeekerDto> jobSeekersDto = jobSeekerMapper.map(jobSeekers);
        return jobSeekersDto;
    }

    @Cacheable(cacheNames = "jobSeekerDto", key = "'jobSeeker#' + #id")
    public JobSeekerDto getById(String id) {
        JobSeeker jobSeeker = findById(id);
        JobSeekerDto jobSeekerDto = jobSeekerMapper.map(jobSeeker);
        return jobSeekerDto;
    }

     protected JobSeeker findById(String id) {
        JobSeeker jobSeeker =  this.jobSeekerRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Job seeker is not found: " + id));
        return jobSeeker;
    }

    @CacheEvict(cacheNames = { "jobSeekerDto", "jobSeekersDto" }, allEntries = true)
    public JobSeekerDto create(CreateJobSeekerDto createJobSeekerDto) {
        if (checkIfEmailExistsForCreate(createJobSeekerDto.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + createJobSeekerDto.getEmail());
        }

        JobSeeker jobSeeker = this.jobSeekerMapper.map(createJobSeekerDto);
        jobSeeker.setCreatedDate(LocalDateTime.now());

        City city = this.cityService.findById(createJobSeekerDto.getCityId());
        jobSeeker.setCity(city);

        JobSeeker createdJobSeeker =  this.jobSeekerRepository.save(jobSeeker);
        return this.jobSeekerMapper.map(createdJobSeeker);
    }

    @CacheEvict(cacheNames = { "jobSeekerDto", "jobSeekersDto" }, allEntries = true)
    public JobSeekerDto edit(EditJobSeekerDto editJobSeekerDto) {
        JobSeeker jobSeeker = this.findById(editJobSeekerDto.getId());
        if (checkIfEmailExistsForEdit(jobSeeker.getEmail(), editJobSeekerDto.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + editJobSeekerDto.getEmail());
        }

        JobSeeker editToJobSeeker = jobSeekerMapper.map(editJobSeekerDto);
        City city = this.cityService.findById(editJobSeekerDto.getCityId());

        editToJobSeeker.setCity(city);
        editToJobSeeker.setCreatedDate(jobSeeker.getCreatedDate());
        editToJobSeeker.setUpdatedDate(LocalDateTime.now());

        JobSeeker editedJobSeeker = this.jobSeekerRepository.save(editToJobSeeker);
        return this.jobSeekerMapper.map(editedJobSeeker);
    }

    @CacheEvict(cacheNames = { "jobSeekerDto", "jobSeekersDto" }, allEntries = true)
    public void delete(String id) {
        JobSeeker deleteToJobSeeker = this.findById(id);
        this.jobSeekerRepository.delete(deleteToJobSeeker);
    }

    private boolean checkIfEmailExistsForEdit(String email, String editToEmail) {
        return !email.equals(editToEmail) && this.jobSeekerRepository.existsByEmail(email);
    }

    private boolean checkIfEmailExistsForCreate(String email) {
        return this.jobSeekerRepository.existsByEmail(email);
    }
}
