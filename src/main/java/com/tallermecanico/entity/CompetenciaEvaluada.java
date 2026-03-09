package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "competencias_evaluadas")
public class CompetenciaEvaluada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evaluacion")
    private EvaluacionEmpleado evaluacionEmpleado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_competencia")
    private Competencia competencia;

    @Column(name = "evaluacion_nota")
    private Integer evaluacionNota;

    @Column(name = "real", precision = 8, scale = 2)
    private BigDecimal real;

    // Constructors
    public CompetenciaEvaluada() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EvaluacionEmpleado getEvaluacionEmpleado() {
        return evaluacionEmpleado;
    }

    public void setEvaluacionEmpleado(EvaluacionEmpleado evaluacionEmpleado) {
        this.evaluacionEmpleado = evaluacionEmpleado;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public Integer getEvaluacionNota() {
        return evaluacionNota;
    }

    public void setEvaluacionNota(Integer evaluacionNota) {
        this.evaluacionNota = evaluacionNota;
    }

    public BigDecimal getReal() {
        return real;
    }

    public void setReal(BigDecimal real) {
        this.real = real;
    }
}
