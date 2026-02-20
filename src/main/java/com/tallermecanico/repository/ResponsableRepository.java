package com.tallermecanico.repository;

import com.tallermecanico.entity.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Integer> {

    @Query("SELECT r FROM Responsable r WHERE LOWER(r.responsable) = LOWER(:responsable)")
    Optional<Responsable> findByResponsableIgnoreCase(@Param("responsable") String responsable);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM Responsable r WHERE LOWER(r.responsable) = LOWER(:responsable)")
    boolean existsByResponsableIgnoreCase(@Param("responsable") String responsable);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM Responsable r WHERE LOWER(r.responsable) = LOWER(:responsable) AND r.id <> :id")
    boolean existsByResponsableIgnoreCaseAndIdNot(@Param("responsable") String responsable, @Param("id") Integer id);
}
