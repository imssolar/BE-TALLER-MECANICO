package com.tallermecanico.repository;

import com.tallermecanico.entity.BusTallerCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusTallerCarRepository extends JpaRepository<BusTallerCar, Integer> {

    List<BusTallerCar> findByTerminal_IdTerminal(Integer idTerminal);
}
