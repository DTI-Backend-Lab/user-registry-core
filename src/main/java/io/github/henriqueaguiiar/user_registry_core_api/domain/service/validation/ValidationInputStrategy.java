package io.github.henriqueaguiiar.user_registry_core_api.domain.service.validation;

import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.request.UsersRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface ValidationInputStrategy {

    void validateInputDTO(UsersRequestDTO usersRequestDTO);
}
