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
public class JobDto {
    private String id;
    private String title;
    private String description;
    private Integer numberOfApplications;
    private String categoryName;
    private String positionName;
    private JobEmployerDto employer;
    private String cityName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}