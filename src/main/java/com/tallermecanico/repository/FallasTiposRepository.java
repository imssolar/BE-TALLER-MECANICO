package com.tallermecanico.repository;

import com.tallermecanico.entity.FallasTipos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FallasTiposRepository extends JpaRepository<FallasTipos, Integer> {

    boolean existsByTipoFallaAndFalla_IdFalla(String tipoFalla, String idFalla);

    boolean existsByTipoFallaAndFalla_IdFallaAndIdNot(String tipoFalla, String idFalla, Integer id);

    List<FallasTipos> findByFalla_IdFalla(String idFalla);
}
