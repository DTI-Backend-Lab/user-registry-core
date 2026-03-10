package io.github.henriqueaguiiar.user_registry_core_api.api.v1.exception;

import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.response.ErroResponseDTO;
import io.github.henriqueaguiiar.user_registry_core_api.domain.exception.UsersEntityException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(UsersEntityException.class)
    public ResponseEntity<ErroResponseDTO> userExceptionHandler(UsersEntityException usersEntityException, HttpServletRequest request) {
        ErroResponseDTO erroResponseDTO = new ErroResponseDTO(
                HttpStatus.BAD_REQUEST,
                usersEntityException.getMessage(),
                request.getRequestURI(),
                java.time.Instant.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroResponseDTO);
    }
}
