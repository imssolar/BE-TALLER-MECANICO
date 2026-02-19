package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "motivo_cambio")
public class MotivoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false, unique = true)
    private String motivo;

    // Constructors
    public MotivoCambio() {
    }

    public MotivoCambio(String motivo) {
        this.motivo = motivo;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
