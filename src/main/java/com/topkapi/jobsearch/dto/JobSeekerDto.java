package com.topkapi.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerDto {
    private String id;
    private String fullName;
    private String summaryInfo;
    private String email;
    private JobSeekerCityDto city;
}
