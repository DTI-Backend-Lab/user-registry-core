package io.github.henriqueaguiiar.user_registry_core_api.api.v1.exception;

import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.response.ErroResponseDTO;
import io.github.henriqueaguiiar.user_registry_core_api.domain.exception.UsersEntityException;
import io.github.henriqueaguiiar.user_registry_core_api.util.DataConfiguration;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global exception handler for the application.
 * This class handles exceptions thrown by controllers and services, providing a consistent error response format.
 */

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(UsersEntityException.class)
    public ResponseEntity<ErroResponseDTO> userExceptionHandler(UsersEntityException usersEntityException, HttpServletRequest request) {
        ErroResponseDTO erroResponseDTO = new ErroResponseDTO(
                HttpStatus.BAD_REQUEST,
                usersEntityException.getMessage(),
                request.getRequestURI(),
                DataConfiguration.nowAtSaoPaulo()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroResponseDTO);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String uri = ((ServletWebRequest) request).getRequest().getRequestURI();
        ErroResponseDTO erroResponseDTO = new ErroResponseDTO(
                HttpStatus.BAD_REQUEST,
                "Validation failed: " + exception.getBindingResult()
                        .getAllErrors()
                        .get(0)
                        .getDefaultMessage(),
                uri,
                DataConfiguration.nowAtSaoPaulo()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroResponseDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponseDTO> genericExceptionHandler(Exception exception, HttpServletRequest request) {
        ErroResponseDTO erroResponseDTO = new ErroResponseDTO(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "An unexpected error occurred.",
                request.getRequestURI(),
                DataConfiguration.nowAtSaoPaulo()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erroResponseDTO);
    }
}
