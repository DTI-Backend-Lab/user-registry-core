package io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.response;

import org.springframework.http.HttpStatus;


import java.time.ZonedDateTime;

public record HealthResponseDTO(String message,
                                HttpStatus status,
                                ZonedDateTime timestamp ) {
}
