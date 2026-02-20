package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "marcas_pastillas")
public class MarcaPastilla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "marca_pastilla", length = 50, nullable = false, unique = true)
    private String marcaPastilla;

    // Constructors
    public MarcaPastilla() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarcaPastilla() {
        return marcaPastilla;
    }

    public void setMarcaPastilla(String marcaPastilla) {
        this.marcaPastilla = marcaPastilla;
    }
}
