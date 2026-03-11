package io.github.henriqueaguiiar.user_registry_core_api.api.v1.controller;

import io.github.henriqueaguiiar.user_registry_core_api.api.v1.dto.response.HealthResponseDTO;
import io.github.henriqueaguiiar.user_registry_core_api.util.DataConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<HealthResponseDTO> health() {
        return ResponseEntity.status(HttpStatus.OK).body(new HealthResponseDTO("API is Running", HttpStatus.OK, DataConfiguration.nowAtSaoPaulo()));
    }
}
