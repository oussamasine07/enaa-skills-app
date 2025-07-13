package com.enaaskills.validationservice.dto.mapping;

import java.util.List;

public record RenderingResponseDTO (
    Long id,
    String message,
    List<String> links,
    Object briefData
) {
}
