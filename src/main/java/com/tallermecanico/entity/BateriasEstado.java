package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "baterias_estado")
public class BateriasEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "estado", length = 20, nullable = false, unique = true)
    private String estado;

    // Constructors
    public BateriasEstado() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
