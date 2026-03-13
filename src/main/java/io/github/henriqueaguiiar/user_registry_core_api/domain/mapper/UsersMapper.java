package io.github.henriqueaguiiar.user_registry_core_api.domain.mapper;

import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.request.UsersRequestDTO;
import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.response.UsersResponseDTO;
import io.github.henriqueaguiiar.user_registry_core_api.domain.entity.Users;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

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

    public void updateEntity(Users user, UsersRequestDTO usersRequestDTO) {
        user.setId(user.getId());
        user.setName(usersRequestDTO.name());
        user.setEmail(usersRequestDTO.email());
        user.setPassword(usersRequestDTO.password());
    }

    public UsersResponseDTO toDTO(Users user) {
        return new UsersResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt().atZone(ZoneId.of("America/Sao_Paulo"))
        );
    }
}
