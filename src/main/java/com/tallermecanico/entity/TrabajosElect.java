package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "trabajos_elect")
public class TrabajosElect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false, unique = true)
    private String tipoTE;

    // Constructors
    public TrabajosElect() {
    }

    public TrabajosElect(String tipoTE) {
        this.tipoTE = tipoTE;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoTE() {
        return tipoTE;
    }

    public void setTipoTE(String tipoTE) {
        this.tipoTE = tipoTE;
    }
}
