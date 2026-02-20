package com.tallermecanico.repository;

import com.tallermecanico.entity.Relator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RelatorRepository extends JpaRepository<Relator, Integer> {

    @Query("SELECT r FROM Relator r WHERE LOWER(r.relator) = LOWER(:relator)")
    Optional<Relator> findByRelatorIgnoreCase(@Param("relator") String relator);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM Relator r WHERE LOWER(r.relator) = LOWER(:relator)")
    boolean existsByRelatorIgnoreCase(@Param("relator") String relator);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM Relator r WHERE LOWER(r.relator) = LOWER(:relator) AND r.id <> :id")
    boolean existsByRelatorIgnoreCaseAndIdNot(@Param("relator") String relator, @Param("id") Integer id);
}
