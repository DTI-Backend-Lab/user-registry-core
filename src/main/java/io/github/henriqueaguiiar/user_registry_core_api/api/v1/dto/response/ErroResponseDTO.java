package io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.response;

import org.springframework.http.HttpStatus;

import java.time.Instant;

/**
 * DTO to represent a global erro response formated with status, message, path and timestamp
 * @param status the HTTP status of the response
 * @param message the error message to be returned to the client
 * @param path the path of the request that caused the error
 * @param timestamp the timestamp of when the error occurred
 */
public record ErroResponseDTO(HttpStatus status,
                              String message,
                              String path,
                              Instant timestamp) {
}
