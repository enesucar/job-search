package com.topkapi.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobDto {
    private String title;
    private String description;
    private String categoryId;
    private String positionId;
    private String employerId;
    private String cityId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
