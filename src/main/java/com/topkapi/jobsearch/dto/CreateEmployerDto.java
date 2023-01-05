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
public class CreateEmployerDto {
    @NotBlank(message = "Name is required.")
    private String name;

    @Length(max = 250, message = "SummaryInfo must contain a maximum of 250 characters.")
    private String summaryInfo;

    @NotBlank(message = "Email is required.")
    private String email;
}
