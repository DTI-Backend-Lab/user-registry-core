package io.github.henriqueaguiiar.user_registry_core_api.api.v1.controller;


import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.request.UsersRequestDTO;
import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.response.UsersResponseDTO;

import io.github.henriqueaguiiar.user_registry_core_api.domain.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<UsersResponseDTO> createUser(@Valid @RequestBody UsersRequestDTO usersRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.createUser(usersRequestDTO));
    }

}
