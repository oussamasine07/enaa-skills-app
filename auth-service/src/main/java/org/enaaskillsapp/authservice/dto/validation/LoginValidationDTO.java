package org.enaaskillsapp.authservice.dto.validation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record LoginValidationDTO (
        @NotEmpty(message = "email is required")
        @Email(message = "should be a valid email")
        String email,

        @NotEmpty( message = "password is required" )
        String password

) {
}
