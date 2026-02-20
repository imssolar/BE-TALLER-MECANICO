package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bateria_motivo_cambio")
public class BateriaMotivoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "motivo_cambio", length = 20, nullable = false, unique = true)
    private String motivoCambio;

    // Constructors
    public BateriaMotivoCambio() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotivoCambio() {
        return motivoCambio;
    }

    public void setMotivoCambio(String motivoCambio) {
        this.motivoCambio = motivoCambio;
    }
}
