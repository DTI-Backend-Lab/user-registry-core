package io.github.henriqueaguiiar.user_registry_core_api.domain.service;

import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.request.UsersRequestDTO;
import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.response.UsersResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {
    UsersResponseDTO createUser(UsersRequestDTO usersRequestDTO);
}
