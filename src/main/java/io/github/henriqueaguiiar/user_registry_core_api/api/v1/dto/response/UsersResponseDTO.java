package io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.response;

import java.time.Instant;
import java.util.UUID;

public record UsersResponseDTO(UUID id,
                               String name,
                               String email,
                               String hashedPassword,
                               Instant createdAt) {
}
