package io.github.henriqueaguiiar.user_registry_core_api.domain.service.validation;

import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.request.UsersRequestDTO;
import io.github.henriqueaguiiar.user_registry_core_api.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PasswordValidationStrategy implements ValidationInputStrategy {

    @Override
    public void validateInputDTO(UsersRequestDTO usersRequestDTO) {
        if (usersRequestDTO.password() == null || usersRequestDTO.password().isEmpty()) {
            log.error("Password is required");
            throw new IllegalArgumentException(Constants.PASSWORD_IS_REQUIRED_MESSAGE);
        }
        if (usersRequestDTO.password().length() < 8) {
            log.error("Password must be at least 8 characters long");
            throw new IllegalArgumentException(Constants.PASSWORD_IS_NOT_VALID);
        }
    }
}
