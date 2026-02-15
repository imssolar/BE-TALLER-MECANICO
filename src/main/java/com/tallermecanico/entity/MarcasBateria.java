package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "marcas_baterias")
public class MarcasBateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, nullable = false)
    private String marca;

    // Constructors
    public MarcasBateria() {
    }

    public MarcasBateria(String marca) {
        this.marca = marca;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
