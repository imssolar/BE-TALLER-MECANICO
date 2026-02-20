package com.tallermecanico.repository;

import com.tallermecanico.entity.TallerExterno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TallerExternoRepository extends JpaRepository<TallerExterno, Integer> {

    boolean existsByRazonSocialIgnoreCase(String razonSocial);
}
