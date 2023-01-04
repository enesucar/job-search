package com.topkapi.jobsearch.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditJobSeekerDto {
    @NotBlank(message = "Id is required.")
    private String id;

    @NotBlank(message = "FirstName is required.")
    private String firstName;

    @NotBlank(message = "LastName is required.")
    private String lastName;

    @Length(max = 250, message = "SummaryInfo must contain a maximum of 250 characters.")
    private String summaryInfo;

    @NotBlank(message = "City is required.")
    private String cityId;

    @NotBlank(message = "Email is required.")
    private String email;
}
