package com.topkapi.jobsearch.service;

import com.topkapi.jobsearch.dto.CreateJobSeekerDto;
import com.topkapi.jobsearch.dto.EditJobSeekerDto;
import com.topkapi.jobsearch.dto.JobSeekerDto;
import com.topkapi.jobsearch.exception.EmailAlreadyExistsException;
import com.topkapi.jobsearch.exception.EmailIsInvalidException;
import com.topkapi.jobsearch.exception.EntityNotFoundException;
import com.topkapi.jobsearch.mapper.JobSeekerMapper;
import com.topkapi.jobsearch.model.City;
import com.topkapi.jobsearch.model.JobSeeker;
import com.topkapi.jobsearch.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobSeekerService {
    private final JobSeekerRepository jobSeekerRepository;
    private final JobSeekerMapper jobSeekerMapper;
    private final CityService cityService;
    private final CheckEmailService checkEmailService;

    public JobSeekerService(JobSeekerRepository jobSeekerRepository,
                            JobSeekerMapper jobSeekerMapper,
                            CityService cityService,
                            @Qualifier("javaxMailCheckEmailService")CheckEmailService checkEmailService) {
        this.jobSeekerRepository = jobSeekerRepository;
        this.jobSeekerMapper = jobSeekerMapper;
        this.cityService = cityService;
        this.checkEmailService = checkEmailService;
    }

    public List<JobSeekerDto> getList() {
        List<JobSeeker> jobSeekers = this.jobSeekerRepository.findAll();
        return jobSeekerMapper.map(jobSeekers);
    }

    public JobSeekerDto getById(String id) {
        JobSeeker jobSeeker = findById(id);
        return jobSeekerMapper.map(jobSeeker);
    }

     protected JobSeeker findById(String id) {
        JobSeeker jobSeeker =  this.jobSeekerRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Job seeker is not found: " + id));
        return jobSeeker;
    }

    public JobSeekerDto create(CreateJobSeekerDto createJobSeekerDto) {
        if (!checkEmailService.isValid(createJobSeekerDto.getEmail())) {
            throw new EmailIsInvalidException("Email is not valid: " + createJobSeekerDto.getEmail());
        }

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

    public JobSeekerDto edit(EditJobSeekerDto editJobSeekerDto) {
        if (!checkEmailService.isValid(editJobSeekerDto.getEmail())) {
            throw new EmailIsInvalidException("Email is not valid: " + editJobSeekerDto.getEmail());
        }

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

    public void delete(String id) {
        JobSeeker deleteToJobSeeker = this.findById(id);
        this.jobSeekerRepository.delete(deleteToJobSeeker);
    }

    private boolean checkIfEmailExistsForCreate(String email) {
        return this.jobSeekerRepository.existsByEmail(email);
    }

    private boolean checkIfEmailExistsForEdit(String email, String editToEmail) {
        return !email.equals(editToEmail) && this.jobSeekerRepository.existsByEmail(editToEmail);
    }
}
