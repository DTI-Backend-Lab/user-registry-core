package io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsersRequestDTO(
                            @NotBlank(message = "Name is required")
                            String name,
                            @Email(message = "Invalid email format")
                            @NotBlank(message = "Email is required")
                            String email,
                            @NotBlank(message = "Password is required")
                            @Size(min = 8, max = 16, message = "Password must be between min 8 and max 16 characters")
                            String password) {
}
