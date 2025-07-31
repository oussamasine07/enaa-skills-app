package org.enaaskillsapp.authservice.dto.validation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterUserValidationDTO(
        @NotBlank(message = "first name field is reauired")
        String firstName,

        @NotBlank(message = "last name is reauired")
        String lastName,

        @NotBlank(message = "email is reauired")
        @Email(message = "please enter a valid email")
        String email,

        @NotBlank(message = "password is reauired")
        @Size(min = 6, message = "password should be at least 6 characters")
        String password,

        @NotBlank(message = "role is reauired")
        String role


) {
}
