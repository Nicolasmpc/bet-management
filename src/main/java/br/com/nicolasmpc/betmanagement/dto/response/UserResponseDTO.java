package br.com.nicolasmpc.betmanagement.dto.response;

import br.com.nicolasmpc.betmanagement.dto.DTO;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class UserResponseDTO extends DTO {

    private UUID id;
    private String username;

    public UserResponseDTO() {
    }

    public UserResponseDTO(UUID id, String username) {
        super();
        this.id = id;
        this.username = username;
    }

    public UserResponseDTO(HttpStatus statusCode, boolean success, UserResponseDTO userResponseDTO) {
        super(statusCode, success);
        this.id = userResponseDTO.getId();
        this.username = userResponseDTO.getUsername();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
