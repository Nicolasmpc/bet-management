package br.com.nicolasmpc.betmanagement.controller;

import br.com.nicolasmpc.betmanagement.dto.request.UserRequestDTO;
import br.com.nicolasmpc.betmanagement.dto.response.UserResponseDTO;
import br.com.nicolasmpc.betmanagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<String> index() {
        return ResponseEntity.ok().body("Hello World!");
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO user) {

        UserResponseDTO userResponseDTO = userService.createUser(user);
        userResponseDTO.setSuccess(true);
        userResponseDTO.setStatusCode(HttpStatus.CREATED);

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserRequestDTO userRequestDTO, @PathVariable String id) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        try {
            userResponseDTO = userService.updateUser(userRequestDTO, id);

            userResponseDTO.setMessage("");
            userResponseDTO.setSuccess(true);
            userResponseDTO.setStatusCode(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            userResponseDTO.setStatusCode(HttpStatus.NOT_FOUND);
            userResponseDTO.setSuccess(false);
            userResponseDTO.setMessage(e.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userResponseDTO);
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDTO);
    }
}
