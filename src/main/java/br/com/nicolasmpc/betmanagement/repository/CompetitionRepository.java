package br.com.nicolasmpc.betmanagement.repository;

import br.com.nicolasmpc.betmanagement.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, UUID> {
}
