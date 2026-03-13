package io.github.henriqueaguiiar.user_registry_core_api.domain.service;

import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.request.UsersRequestDTO;
import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.response.UsersResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UsersService {


    UsersResponseDTO createUser(UsersRequestDTO usersRequestDTO);

    List<UsersResponseDTO> getAllUsers();

    UsersResponseDTO getUser(UUID userId);

    UsersResponseDTO updateUser(UUID userId, UsersRequestDTO usersRequestDTO);

    UsersResponseDTO updateUserParse(UUID userId, UsersRequestDTO usersRequestDTO);

    void deleteUser(UUID userId);

}
