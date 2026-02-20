package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "competencia_areas")
public class CompetenciaArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false, unique = true)
    private String area;

    @Column(name = "ponderacion", precision = 8, scale = 2)
    private BigDecimal ponderacion;

    // Constructors
    public CompetenciaArea() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public BigDecimal getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(BigDecimal ponderacion) {
        this.ponderacion = ponderacion;
    }
}
