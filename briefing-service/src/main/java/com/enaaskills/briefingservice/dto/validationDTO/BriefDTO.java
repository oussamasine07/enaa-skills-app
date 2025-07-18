package com.enaaskills.briefingservice.dto.validationDTO;

import com.enaaskills.briefingservice.model.Engagement;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record BriefDTO (
        @NotBlank(message = "title field is required")
        String title,

        @NotBlank(message = "description field is required")
        String description,

        @NotNull(message = "start date is required")
        LocalDate startDate,

        @NotNull(message = "end date is required")
        LocalDate endDate,

        @NotNull(message = "duration field is required")
        Integer duration,

        @NotNull(message = "engagment field is required")
        Engagement engagement
) {

}
