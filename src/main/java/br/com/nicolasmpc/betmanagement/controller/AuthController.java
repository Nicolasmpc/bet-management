package br.com.nicolasmpc.betmanagement.controller;

import br.com.nicolasmpc.betmanagement.dto.response.AuthResponseDTO;
import br.com.nicolasmpc.betmanagement.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<AuthResponseDTO> authenticate(Authentication auth) {
        Jwt jwt = authService.generateToken(auth);

        LocalDateTime expiresAt = LocalDateTime.ofInstant(Objects.requireNonNull(jwt.getExpiresAt()), ZoneId.of("America/Sao_Paulo"));

        return ResponseEntity.ok().
                body(new AuthResponseDTO(
                        HttpStatus.OK,
                        true,
                        jwt.getTokenValue(),
                        expiresAt
                ));
    }
}
