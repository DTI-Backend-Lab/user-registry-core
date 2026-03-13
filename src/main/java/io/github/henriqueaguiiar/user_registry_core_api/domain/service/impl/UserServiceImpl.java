package io.github.henriqueaguiiar.user_registry_core_api.domain.service.impl;

import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.request.UsersRequestDTO;
import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.response.UsersResponseDTO;
import io.github.henriqueaguiiar.user_registry_core_api.domain.entity.Users;
import io.github.henriqueaguiiar.user_registry_core_api.domain.exception.UsersEntityException;
import io.github.henriqueaguiiar.user_registry_core_api.domain.mapper.UsersMapper;
import io.github.henriqueaguiiar.user_registry_core_api.domain.repository.UsersRepository;
import io.github.henriqueaguiiar.user_registry_core_api.domain.service.UsersService;
import io.github.henriqueaguiiar.user_registry_core_api.domain.service.validation.ValidateFieldsStrategy;
import io.github.henriqueaguiiar.user_registry_core_api.domain.service.validation.ValidationInputStrategy;
import io.github.henriqueaguiiar.user_registry_core_api.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;
    List<ValidationInputStrategy>  validationInputStrategies;
    List<ValidateFieldsStrategy>  validateFieldsStrategies;

    public UserServiceImpl(UsersRepository usersRepository, UsersMapper usersMapper,  List<ValidationInputStrategy> validationInputStrategy, List<ValidateFieldsStrategy> validateFieldsStrategy) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
        this.validationInputStrategies = validationInputStrategy;
        this.validateFieldsStrategies = validateFieldsStrategy;
    }
    @Override
    public UsersResponseDTO createUser(UsersRequestDTO usersRequestDTO) {
        if(!usersRepository.findByEmail(usersRequestDTO.email()).isEmpty()) {
            throw new UsersEntityException(Constants.EMAIL_ALREADY_EXISTS_MESSAGE);
        }
        for (ValidationInputStrategy strategy : validationInputStrategies) {
            strategy.validateInputDTO(usersRequestDTO);
        }
        log.info("User created:  {}", usersRequestDTO.name());
        return usersMapper.toDTO(usersRepository.save(usersMapper.toEntity(usersRequestDTO)));
    }

    @Override
    public List<UsersResponseDTO> getAllUsers() {
        List<UsersResponseDTO> users = new ArrayList<>();
        for(Users user : usersRepository.findAll()) {
            users.add(usersMapper.toDTO(user));
        }
        if(users.isEmpty()) {
            throw new UsersEntityException(Constants.USER_NOT_FOUND_MESSAGE);
        }
        return users;
    }

    @Override
    public UsersResponseDTO getUser(UUID userId) {
        Users user = usersRepository.findById(userId).orElseThrow(()-> new UsersEntityException(Constants.USER_NOT_FOUND_MESSAGE));
        return usersMapper.toDTO(user);
    }
    @Override
    public UsersResponseDTO updateUser(UUID userId, UsersRequestDTO usersRequestDTO) {
        Users userToUpdate = usersRepository.findById(userId)
                .orElseThrow(() -> new UsersEntityException(Constants.USER_NOT_FOUND_MESSAGE));
        usersMapper.updateEntity(userToUpdate, usersRequestDTO);
        log.info("User updated:  {}", usersRequestDTO.name());
        return usersMapper.toDTO(usersRepository.save(userToUpdate));
    }

    @Override
    public UsersResponseDTO updateUserParse(UUID userId, UsersRequestDTO usersRequestDTO) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new UsersEntityException(Constants.USER_NOT_FOUND_MESSAGE));

        for(ValidateFieldsStrategy strategy : validateFieldsStrategies) {
            strategy.validateField(usersRequestDTO, user);
        }

        log.info("User updated: {}", user.getId());
        return usersMapper.toDTO(usersRepository.save(user));
    }

    @Override
    public void deleteUser(UUID userId) {
        Users userToDelete = usersRepository.findById(userId)
                .orElseThrow(() -> new UsersEntityException(Constants.USER_NOT_FOUND_MESSAGE));
        usersRepository.delete(userToDelete);
        log.info("User deleted: {}", userId);
    }
}
