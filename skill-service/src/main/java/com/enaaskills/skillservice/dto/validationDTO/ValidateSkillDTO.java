package com.enaaskills.skillservice.dto.validationDTO;

import jakarta.validation.constraints.NotBlank;

public record ValidateSkillDTO(
        @NotBlank(message = "skill name field is required")
        String name
) {
}
