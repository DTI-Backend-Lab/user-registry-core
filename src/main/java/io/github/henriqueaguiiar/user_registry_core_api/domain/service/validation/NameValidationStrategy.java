package io.github.henriqueaguiiar.user_registry_core_api.domain.service.validation;

import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.request.UsersRequestDTO;
import io.github.henriqueaguiiar.user_registry_core_api.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NameValidationStrategy implements ValidationInputStrategy {
    @Override
    public void validateInputDTO(UsersRequestDTO usersRequestDTO) {
        if(usersRequestDTO.name() == null || usersRequestDTO.name().isEmpty()) {
            log.error("Name is required");
            throw new IllegalArgumentException(Constants.NAME_IS_REQUIRED_MESSAGE);
        }
    }
}
