package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "gravedad_carroceria")
public class GravedadCarroceria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, nullable = false, unique = true)
    private String gravedad;

    // Constructors
    public GravedadCarroceria() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }
}
