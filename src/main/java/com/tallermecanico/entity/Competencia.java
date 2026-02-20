package com.tallermecanico.entity;

import com.tallermecanico.enums.CargoEmpleado;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "competencias")
public class Competencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo", length = 20)
    private CargoEmpleado cargo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_competencia_area")
    private CompetenciaArea competenciaArea;

    @Column(name = "competencia", length = 100)
    private String competencia;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "teorico", precision = 8, scale = 2)
    private BigDecimal teorico;

    // Constructors
    public Competencia() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CargoEmpleado getCargo() {
        return cargo;
    }

    public void setCargo(CargoEmpleado cargo) {
        this.cargo = cargo;
    }

    public CompetenciaArea getCompetenciaArea() {
        return competenciaArea;
    }

    public void setCompetenciaArea(CompetenciaArea competenciaArea) {
        this.competenciaArea = competenciaArea;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public BigDecimal getTeorico() {
        return teorico;
    }

    public void setTeorico(BigDecimal teorico) {
        this.teorico = teorico;
    }
}
