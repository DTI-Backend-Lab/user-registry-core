package io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;


import java.time.ZonedDateTime;

@Schema(name = "HealthResponseDTO", description = "DTO for API health check response")
public record HealthResponseDTO(
                                @Schema(example = "API is Running", description = "Message indicating the health status of the API")
                                String message,
                                @Schema(example = "200", description = "HTTP status code representing the health status of the API")
                                HttpStatus status,
                                @Schema(example = "2024-06-01T12:00:00Z", description = "Timestamp of the health check")
                                ZonedDateTime timestamp ) {
}
