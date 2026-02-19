package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_visa")
public class TipoVisa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_visa", length = 50, nullable = false, unique = true)
    private String tipoVisa;

    // Constructors
    public TipoVisa() {
    }

    public TipoVisa(String tipoVisa) {
        this.tipoVisa = tipoVisa;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoVisa() {
        return tipoVisa;
    }

    public void setTipoVisa(String tipoVisa) {
        this.tipoVisa = tipoVisa;
    }
}
