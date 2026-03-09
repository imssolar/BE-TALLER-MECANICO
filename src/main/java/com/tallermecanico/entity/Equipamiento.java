package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "equipamiento")
public class Equipamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false, unique = true)
    private String equipamiento;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal costo;

    @Column(precision = 10, scale = 2)
    private BigDecimal cambio;

    // Constructors
    public Equipamiento() {
    }

    public Equipamiento(String equipamiento, BigDecimal costo, BigDecimal cambio) {
        this.equipamiento = equipamiento;
        this.costo = costo;
        this.cambio = cambio;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(String equipamiento) {
        this.equipamiento = equipamiento;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getCambio() {
        return cambio;
    }

    public void setCambio(BigDecimal cambio) {
        this.cambio = cambio;
    }
}
