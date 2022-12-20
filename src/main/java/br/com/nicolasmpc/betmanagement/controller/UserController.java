package br.com.nicolasmpc.betmanagement.controller;

import br.com.nicolasmpc.betmanagement.dto.request.UserRequestDTO;
import br.com.nicolasmpc.betmanagement.dto.response.UserResponseDTO;
import br.com.nicolasmpc.betmanagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<UserResponseDTO> createUser(UserRequestDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }
}
