package br.com.nicolasmpc.betmanagement.dto.request;


import br.com.nicolasmpc.betmanagement.enums.RoleName;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class UserRequestDTO {

    private String username;
    private String password;
    private List<RoleName> roles;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String username, String password, List<RoleName> roles) {
        this.username = username;
        setPassword(password);
        setRoles(roles);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }

    public List<RoleName> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleName> roles) {



        this.roles = roles;
    }
}
