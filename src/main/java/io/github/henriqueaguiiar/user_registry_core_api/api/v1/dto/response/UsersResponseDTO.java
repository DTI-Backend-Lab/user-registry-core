package io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;

import java.time.ZonedDateTime;
import java.util.UUID;

@Schema(name = "UsersResponseDTO", description = "Data transfer object representing the response for user-related operations")
public record UsersResponseDTO(
                               @Schema(example = "123e4567-e89b-12d3-a456-426614174000", description = "Unique identifier of the user")
                               UUID id,
                               @Schema(example = "Henrique Aguiar", description = "Name of the user")
                               String name,
                               @Schema(example = "henrique@gmail.com", description = "Email of the user")
                               String email,
                               @Schema(example = "2024-06-01T12:00:00Z", description = "Creation timestamp of the user")
                               ZonedDateTime createdAt) {
}
