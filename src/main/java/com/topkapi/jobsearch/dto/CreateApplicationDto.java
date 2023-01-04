package com.topkapi.jobsearch.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicationDto {
    @NotBlank(message = "Job is required.")
    private String jobId;

    @NotBlank(message = "JobSeeker is required.")
    private String jobSeekerId;
}
