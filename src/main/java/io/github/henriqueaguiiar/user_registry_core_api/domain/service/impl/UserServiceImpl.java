package io.github.henriqueaguiiar.user_registry_core_api.domain.service.impl;

import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.request.UsersRequestDTO;
import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.response.UsersResponseDTO;
import io.github.henriqueaguiiar.user_registry_core_api.domain.exception.UsersEntityException;
import io.github.henriqueaguiiar.user_registry_core_api.domain.mapper.UsersMapper;
import io.github.henriqueaguiiar.user_registry_core_api.domain.repository.UsersRepository;
import io.github.henriqueaguiiar.user_registry_core_api.domain.service.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    public UserServiceImpl(UsersRepository usersRepository, UsersMapper usersMapper) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
    }
    @Override
    public UsersResponseDTO createUser(UsersRequestDTO usersRequestDTO) {
        if((usersRequestDTO.name().isEmpty() || usersRequestDTO.name() == null) || (usersRequestDTO.password().isEmpty() || usersRequestDTO.password() == null) || (usersRequestDTO.email().isEmpty() || usersRequestDTO.email() == null)) {
            throw new UsersEntityException("Name, password and email are required fields");
        }
        return usersMapper.toDTO(usersRepository.save(usersMapper.toEntity(usersRequestDTO)));
    }
}
