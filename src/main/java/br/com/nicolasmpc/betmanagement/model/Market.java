package br.com.nicolasmpc.betmanagement.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_MARKET")
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    public Market() {
    }

    public Market(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
