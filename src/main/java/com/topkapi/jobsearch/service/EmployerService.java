package com.topkapi.jobsearch.service;

import com.topkapi.jobsearch.dto.*;
import com.topkapi.jobsearch.exception.EmailAlreadyExistsException;
import com.topkapi.jobsearch.exception.EmailIsInvalidException;
import com.topkapi.jobsearch.exception.EntityNotFoundException;
import com.topkapi.jobsearch.mapper.EmployerMapper;
import com.topkapi.jobsearch.model.Employer;
import com.topkapi.jobsearch.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployerService {
    private final EmployerRepository employerRepository;
    private final EmployerMapper employerMapper;
    private final CheckEmailService checkEmailService;

    public EmployerService(EmployerRepository employerRepository,
                           EmployerMapper employerMapper,
                           @Qualifier("javaxMailCheckEmailService")CheckEmailService checkEmailService) {
        this.employerRepository = employerRepository;
        this.employerMapper = employerMapper;
        this.checkEmailService = checkEmailService;
    }

    public List<EmployerDto> getList() {
        List<Employer> employers = this.employerRepository.findAll();
        return employerMapper.map(employers);
    }

    public EmployerDto getById(String id) {
        Employer employer = findById(id);
        return employerMapper.map(employer);
    }

    protected Employer findById(String id) {
        Employer employer =  this.employerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employer is not found: " + id));
        return employer;
    }

    public EmployerDto create(CreateEmployerDto createEmployerDto) {
        if (!checkEmailService.isValid(createEmployerDto.getEmail())) {
            throw new EmailIsInvalidException("Email is not valid: " + createEmployerDto.getEmail());
        }

        if (checkIfEmailExistsForCreate(createEmployerDto.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + createEmployerDto.getEmail());
        }

        Employer employer = this.employerMapper.map(createEmployerDto);
        employer.setCreatedDate(LocalDateTime.now());

        Employer createdEmployer =  this.employerRepository.save(employer);
        return this.employerMapper.map(createdEmployer);
    }

    public EmployerDto edit(EditEmployerDto editEmployerDto) {
        if (!checkEmailService.isValid(editEmployerDto.getEmail())) {
            throw new EmailIsInvalidException("Email is not valid: " + editEmployerDto.getEmail());
        }

        Employer employer = this.findById(editEmployerDto.getId());
        if (checkIfEmailExistsForEdit(employer.getEmail(), editEmployerDto.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + editEmployerDto.getEmail());
        }

        Employer editToEmployer = this.employerMapper.map(editEmployerDto);
        editToEmployer.setCreatedDate(employer.getCreatedDate());
        editToEmployer.setUpdatedDate(LocalDateTime.now());

        Employer editedEmployer = this.employerRepository.save(editToEmployer);
        return this.employerMapper.map(editedEmployer);
    }

    public void delete(String id) {
        Employer deleteToEmployer = this.findById(id);
        this.employerRepository.delete(deleteToEmployer);
    }

    private boolean checkIfEmailExistsForCreate(String email) {
        return this.employerRepository.existsByEmail(email);
    }

    private boolean checkIfEmailExistsForEdit(String email, String editToEmail) {
        System.out.println(email);
        System.out.println("----");
        System.out.println(editToEmail);
        System.out.println("----");
        System.out.println(this.employerRepository.existsByEmail(email));
        System.out.println("------");
        return !email.equals(editToEmail) && this.employerRepository.existsByEmail(editToEmail);
    }
}
