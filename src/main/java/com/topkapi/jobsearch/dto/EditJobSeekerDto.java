package com.topkapi.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditJobSeekerDto {
    private String id;
    private String firstName;
    private String lastName;
    private String summaryInfo;
    private String cityId;
    private String email;
}