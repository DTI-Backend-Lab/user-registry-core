package io.github.henriqueaguiiar.user_registry_core_api.domain.service.validation;

import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.request.UsersRequestDTO;
import io.github.henriqueaguiiar.user_registry_core_api.domain.entity.Users;
import io.github.henriqueaguiiar.user_registry_core_api.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NameFieldStrategy implements ValidateFieldsStrategy {
    @Override
    public void validateField(UsersRequestDTO usersRequestDTO, Users users) {
        if(!usersRequestDTO.name().isEmpty()){
            users.setName(usersRequestDTO.name());
        }
        else {
            log.error("Name is required");
            throw new IllegalArgumentException(Constants.NAME_IS_REQUIRED_MESSAGE);
        }
    }
}
