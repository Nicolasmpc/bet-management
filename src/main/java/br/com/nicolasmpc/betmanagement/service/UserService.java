package br.com.nicolasmpc.betmanagement.service;

import br.com.nicolasmpc.betmanagement.dto.request.UserRequestDTO;
import br.com.nicolasmpc.betmanagement.dto.response.UserResponseDTO;
import br.com.nicolasmpc.betmanagement.model.Role;
import br.com.nicolasmpc.betmanagement.model.User;
import br.com.nicolasmpc.betmanagement.repository.RoleRepository;
import br.com.nicolasmpc.betmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {

        List<Role> roles = new ArrayList<>();

        userRequestDTO.getRoles().forEach(
                roleName -> {
                    Role role = roleRepository.findByName(roleName).orElseThrow(
                            () -> new NoSuchElementException("Role Not Found: " + roleName)
                    );
                    roles.add(role);
                }
        );

        User user = dtoToUser(userRequestDTO, roles);

        return userToDto(userRepository.save(user));
    }

    private User dtoToUser(UserRequestDTO userRequestDTO, List<Role> roles) {
        return new User(
                userRequestDTO.getUsername(),
                userRequestDTO.getPassword(),
                roles
        );
    }

    private UserResponseDTO userToDto(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getUsername()
        );
    }
}
