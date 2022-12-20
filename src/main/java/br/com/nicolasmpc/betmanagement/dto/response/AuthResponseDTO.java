package br.com.nicolasmpc.betmanagement.dto.response;

import br.com.nicolasmpc.betmanagement.dto.DTO;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class AuthResponseDTO extends DTO {

    private String token;
    private LocalDateTime expiresAt;

    public AuthResponseDTO(HttpStatus statusCode, boolean success, String token, LocalDateTime expiresAt) {
        super(statusCode, success);
        this.token = token;
        this.expiresAt = expiresAt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}
