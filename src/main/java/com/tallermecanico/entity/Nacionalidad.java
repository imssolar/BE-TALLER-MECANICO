package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nacionalidades")
public class Nacionalidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false, unique = true)
    private String nacionalidad;

    // Constructors
    public Nacionalidad() {
    }

    public Nacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
