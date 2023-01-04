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
public class EditJobDto {
    private String id;
    private String title;
    private String description;
    private String categoryId;
    private String positionId;
    private String employerId;
    private String cityId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
