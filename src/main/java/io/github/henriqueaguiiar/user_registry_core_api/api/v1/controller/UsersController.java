package io.github.henriqueaguiiar.user_registry_core_api.api.v1.controller;


import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.request.UsersRequestDTO;
import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.response.UsersResponseDTO;

import io.github.henriqueaguiiar.user_registry_core_api.domain.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "Endpoints for managing users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }



    @PostMapping
    @Operation(summary = "Create a new user", description = "Creates a new user with the provided information")
    @ApiResponse(responseCode = "201", description = "User created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    public ResponseEntity<UsersResponseDTO> createUser(@Valid @RequestBody UsersRequestDTO usersRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.createUser(usersRequestDTO));
    }

}
