package com.tallermecanico.repository;

import com.tallermecanico.entity.CostoSM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostoSMRepository extends JpaRepository<CostoSM, Integer> {
}
