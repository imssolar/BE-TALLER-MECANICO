package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bateria_modelos")
public class BateriaModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "modelo", length = 20, nullable = false, unique = true)
    private String modelo;

    @Column(name = "rendimiento", precision = 10, scale = 2)
    private BigDecimal rendimiento;

    // Constructors
    public BateriaModelo() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public BigDecimal getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(BigDecimal rendimiento) {
        this.rendimiento = rendimiento;
    }
}
