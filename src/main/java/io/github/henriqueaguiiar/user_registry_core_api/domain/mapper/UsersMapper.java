package io.github.henriqueaguiiar.user_registry_core_api.domain.mapper;

import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.request.UsersRequestDTO;
import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.response.UsersResponseDTO;
import io.github.henriqueaguiiar.user_registry_core_api.domain.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {

    public Users toEntity(UsersRequestDTO UserRequestDTO) {
        return new Users(
                null,
                UserRequestDTO.name(),
                UserRequestDTO.email(),
                UserRequestDTO.password(),
                null
        );
    }

    public UsersResponseDTO toDTO(Users user) {
        return new UsersResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getCreatedAt()
        );
    }
}
