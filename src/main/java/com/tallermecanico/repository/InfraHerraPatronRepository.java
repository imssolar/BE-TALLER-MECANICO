package com.tallermecanico.repository;

import com.tallermecanico.entity.InfraHerraPatron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfraHerraPatronRepository extends JpaRepository<InfraHerraPatron, String> {

    List<InfraHerraPatron> findByTerminal_IdTerminal(Integer idTerminal);
}
