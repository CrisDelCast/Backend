package co.edu.icesi.pf.infrastructure.entrypoint.apirest.dto.user;

import jakarta.validation.constraints.NotBlank;

public record UserLoginDTO(
        @NotBlank(message = "Email is required")
        String email,
        @NotBlank(message = "Password is required")
        String password
) {}
