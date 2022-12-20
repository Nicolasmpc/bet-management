package br.com.nicolasmpc.betmanagement.repository;

import br.com.nicolasmpc.betmanagement.enums.RoleName;
import br.com.nicolasmpc.betmanagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

    @Query("SELECT r FROM Role r WHERE r.name = ?1")
    Optional<Role> findByName(RoleName name);
}
