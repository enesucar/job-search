package com.topkapi.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerDto implements Serializable {
    private String id;
    private String fullName;
    private String summaryInfo;
    private String email;
    private JobSeekerCityDto city;
}
