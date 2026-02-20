package com.tallermecanico.repository;

import com.tallermecanico.entity.ItemRRHH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRRHHRepository extends JpaRepository<ItemRRHH, Integer> {

    @Query("SELECT i FROM ItemRRHH i WHERE LOWER(i.item) = LOWER(:item)")
    Optional<ItemRRHH> findByItemIgnoreCase(@Param("item") String item);

    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN true ELSE false END FROM ItemRRHH i WHERE LOWER(i.item) = LOWER(:item)")
    boolean existsByItemIgnoreCase(@Param("item") String item);

    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN true ELSE false END FROM ItemRRHH i WHERE LOWER(i.item) = LOWER(:item) AND i.id <> :id")
    boolean existsByItemIgnoreCaseAndIdNot(@Param("item") String item, @Param("id") Integer id);
}
