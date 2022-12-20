package br.com.nicolasmpc.betmanagement.service;

import br.com.nicolasmpc.betmanagement.dto.request.UserRequestDTO;
import br.com.nicolasmpc.betmanagement.dto.response.UserResponseDTO;
import br.com.nicolasmpc.betmanagement.enums.RoleName;
import br.com.nicolasmpc.betmanagement.model.Role;
import br.com.nicolasmpc.betmanagement.model.User;
import br.com.nicolasmpc.betmanagement.repository.RoleRepository;
import br.com.nicolasmpc.betmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {

        List<Role> roles = roleNameEnumToRolesList(userRequestDTO.getRoles());
        User user = dtoToUser(userRequestDTO, roles);

        return userToDto(userRepository.save(user));
    }

    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO, String id) {

        User user = userRepository.findById(UUID.fromString(id)).orElseThrow(
                () -> new NoSuchElementException("User Not Found with id: " + id)
        );

        user.setUsername(userRequestDTO.getUsername());
        user.setPassword(userRequestDTO.getPassword());
        user.setRoles(roleNameEnumToRolesList(userRequestDTO.getRoles()));

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

    private List<Role> roleNameEnumToRolesList(List<RoleName> roleNames) {
        List<Role> roles = new ArrayList<>();
        roleNames.forEach(
                roleName -> {
                    Role role = roleService.findRoleByName(roleName);
                    roles.add(role);
                }
        );

        return roles;
    }
}
