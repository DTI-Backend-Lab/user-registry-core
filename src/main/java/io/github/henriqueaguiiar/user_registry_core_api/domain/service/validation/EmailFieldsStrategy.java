package io.github.henriqueaguiiar.user_registry_core_api.domain.service.validation;

import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.request.UsersRequestDTO;
import io.github.henriqueaguiiar.user_registry_core_api.domain.entity.Users;
import io.github.henriqueaguiiar.user_registry_core_api.util.Constants;
import org.springframework.stereotype.Component;

@Component
public class EmailFieldsStrategy implements ValidateFieldsStrategy{
    @Override
    public void validateField(UsersRequestDTO usersRequestDTO, Users users) {
        if(!usersRequestDTO.email().isEmpty()){
            users.setEmail(usersRequestDTO.email());
        }
        else {
            throw new IllegalArgumentException(Constants.EMAIL_IS_REQUIRED_MESSAGE);
        }
    }
}
