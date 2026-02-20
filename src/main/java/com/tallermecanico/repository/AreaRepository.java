package com.tallermecanico.repository;

import com.tallermecanico.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {

    @Query("SELECT a FROM Area a WHERE LOWER(a.area) = LOWER(:area)")
    Optional<Area> findByAreaIgnoreCase(@Param("area") String area);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Area a WHERE LOWER(a.area) = LOWER(:area)")
    boolean existsByAreaIgnoreCase(@Param("area") String area);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Area a WHERE LOWER(a.area) = LOWER(:area) AND a.id <> :id")
    boolean existsByAreaIgnoreCaseAndIdNot(@Param("area") String area, @Param("id") Integer id);
}
