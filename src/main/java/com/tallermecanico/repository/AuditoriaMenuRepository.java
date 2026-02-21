package com.tallermecanico.repository;

import com.tallermecanico.entity.AuditoriaMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AuditoriaMenuRepository extends JpaRepository<AuditoriaMenu, Long> {

    List<AuditoriaMenu> findByUsuario(String usuario);

    List<AuditoriaMenu> findByFechaBetween(LocalDateTime desde, LocalDateTime hasta);
}
