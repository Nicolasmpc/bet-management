package br.com.nicolasmpc.betmanagement.service;

import br.com.nicolasmpc.betmanagement.enums.RoleName;
import br.com.nicolasmpc.betmanagement.model.Role;
import br.com.nicolasmpc.betmanagement.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findRoleByName(RoleName name) {
        return roleRepository.findByName(name).orElseThrow(
                () -> new NoSuchElementException("Role Not Found with name: " + name)
        );
    }
}
