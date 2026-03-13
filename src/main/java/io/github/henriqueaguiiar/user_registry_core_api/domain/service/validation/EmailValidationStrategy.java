package io.github.henriqueaguiiar.user_registry_core_api.domain.service.validation;

import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.request.UsersRequestDTO;
import io.github.henriqueaguiiar.user_registry_core_api.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailValidationStrategy implements ValidationInputStrategy{
    @Override
    public void validateInputDTO(UsersRequestDTO usersRequestDTO) {
        if (usersRequestDTO.email() == null || usersRequestDTO.email().isEmpty()) {
            log.error("Email is required");
            throw new IllegalArgumentException(Constants.EMAIL_IS_REQUIRED_MESSAGE);
        }
    }
}
