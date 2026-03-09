package com.tallermecanico.repository;

import com.tallermecanico.entity.ObservacionHojaVida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservacionHojaVidaRepository extends JpaRepository<ObservacionHojaVida, String> {
}
