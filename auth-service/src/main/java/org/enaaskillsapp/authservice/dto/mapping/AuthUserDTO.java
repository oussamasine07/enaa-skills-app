package org.enaaskillsapp.authservice.dto.mapping;

public record AuthUserDTO(
        Long id,
        String firstName,
        String lastName,
        String email
) {
}
