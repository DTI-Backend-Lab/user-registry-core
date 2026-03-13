package io.github.henriqueaguiiar.user_registry_core_api.api.v1.controller;

import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.response.HealthResponseDTO;
import io.github.henriqueaguiiar.user_registry_core_api.util.DataConfiguration;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/health")
@Tag(name = "Health Check", description = "Endpoints related to API health checks.")
public class HealthController {

    @GetMapping
    @Operation(summary = "Check API Health", description = "Endpoint to check if the API is running and healthy.")
    @ApiResponse(responseCode = "200", description = "API is Running")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<HealthResponseDTO> health() {
        log.info("Health check started");
        return ResponseEntity.status(HttpStatus.OK).body(new HealthResponseDTO("API is Running", HttpStatus.OK, DataConfiguration.nowAtSaoPaulo()));
    }
}
