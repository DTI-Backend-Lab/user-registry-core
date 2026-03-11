package io.github.henriqueaguiiar.user_registry_core_api.domain.service.impl;

import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.request.UsersRequestDTO;
import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.response.UsersResponseDTO;
import io.github.henriqueaguiiar.user_registry_core_api.domain.exception.UsersEntityException;
import io.github.henriqueaguiiar.user_registry_core_api.domain.mapper.UsersMapper;
import io.github.henriqueaguiiar.user_registry_core_api.domain.repository.UsersRepository;
import io.github.henriqueaguiiar.user_registry_core_api.domain.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    public UserServiceImpl(UsersRepository usersRepository, UsersMapper usersMapper) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
    }
    @Override
    public UsersResponseDTO createUser(UsersRequestDTO usersRequestDTO) {
        if(usersRequestDTO.name().isEmpty() || usersRequestDTO.password().isEmpty() || usersRequestDTO.email().isEmpty()) {
            throw new UsersEntityException("Name, password and email are required fields");
        }
        log.info("User created:  {}", usersRequestDTO.name());
        return usersMapper.toDTO(usersRepository.save(usersMapper.toEntity(usersRequestDTO)));
    }

    @Override
    public List<UsersResponseDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UsersResponseDTO getUser(UUID userId) {
        return null;
    }
}
