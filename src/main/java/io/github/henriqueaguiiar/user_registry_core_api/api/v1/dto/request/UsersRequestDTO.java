package io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(name = "UsersRequestDTO", description = "Data transfer object representing the request for user-related operations")
public record UsersRequestDTO(
                            @Schema(example = "Henrique Pacheco", description = "The name of the user")
                            @NotBlank(message = "Name is required")
                            String name,
                            @Schema(example = "henrique@gmail.com", description = "The email of the user")
                            @Email(message = "Invalid email format")
                            @NotBlank(message = "Email is required")
                            String email,
                            @Schema(example = "password123", description = "The password of the user")
                            @NotBlank(message = "Password is required")
                            @Size(min = 8, max = 16, message = "Password must be between min 8 and max 16 characters")
                            String password) {
}
