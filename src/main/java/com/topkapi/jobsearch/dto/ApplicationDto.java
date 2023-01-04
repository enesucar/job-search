package com.topkapi.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {
    private String id;
    private ApplicationJobSeekerDto jobSeeker;
    private ApplicationJobDto job;
    private LocalDateTime applicationDate;
}
