package com.tallermecanico.repository;

import com.tallermecanico.entity.ItemMantencion;
import com.tallermecanico.entity.Mantencion;
import com.tallermecanico.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MantencionRepository extends JpaRepository<Mantencion, Integer> {

    boolean existsByItemMantencionAndModelo(ItemMantencion itemMantencion, Modelo modelo);

    boolean existsByItemMantencionAndModeloAndIdNot(ItemMantencion itemMantencion, Modelo modelo, Integer id);
}
