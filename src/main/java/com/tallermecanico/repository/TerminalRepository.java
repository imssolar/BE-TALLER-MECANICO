package com.tallermecanico.repository;

import com.tallermecanico.entity.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Integer> {

    Optional<Terminal> findByTerminal(String terminal);

    Optional<Terminal> findByPrefijo(String prefijo);

    boolean existsByTerminal(String terminal);

    boolean existsByPrefijo(String prefijo);

    boolean existsByTerminalAndIdTerminalNot(String terminal, Integer idTerminal);

    boolean existsByPrefijoAndIdTerminalNot(String prefijo, Integer idTerminal);
}
