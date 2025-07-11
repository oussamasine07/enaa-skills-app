package com.enaaskills.briefingservice.dto.validationDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ValidationBriefSkillDTO(
        @NotNull(message = "skill id is required")
        Long skill_id
) {
}
