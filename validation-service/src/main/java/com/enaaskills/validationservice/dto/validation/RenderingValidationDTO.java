package com.enaaskills.validationservice.dto.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RenderingValidationDTO(

        @NotNull(message = "brief id is required")
        Long brief_id,

        @NotBlank(message = "message is required")
        String message,

        @NotNull
        List<String> links
) {

}
