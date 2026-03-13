package io.github.henriqueaguiiar.user_registry_core_api.domain.service.validation;

import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.request.UsersRequestDTO;
import io.github.henriqueaguiiar.user_registry_core_api.domain.entity.Users;
import io.github.henriqueaguiiar.user_registry_core_api.util.Constants;

public class PasswordFieldStrategy implements ValidateFieldsStrategy{
    @Override
    public void validateField(UsersRequestDTO usersRequestDTO, Users users) {
        if(!usersRequestDTO.password().isEmpty()){
            if(usersRequestDTO.password().length() < 8 && usersRequestDTO.password().length() > 16){
                throw new IllegalArgumentException(Constants.PASSWORD_IS_NOT_VALID);
            }
            users.setPassword(usersRequestDTO.password());
        }
    }
}
