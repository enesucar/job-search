package com.topkapi.jobsearch.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Id is required.")
    private String id;

    @NotBlank(message = "Title is required.")
    private String title;

    @Nullable
    private String description;

    @NotBlank(message = "Category is required.")
    private String categoryId;

    @NotBlank(message = "Position is required.")
    private String positionId;

    @NotBlank(message = "Employer is required.")
    private String employerId;

    @NotBlank(message = "City is required.")
    private String cityId;

    @NotBlank(message = "StartDate is required.")
    private LocalDateTime startDate;

    @NotBlank(message = "EndDate is required.")
    private LocalDateTime endDate;
}
