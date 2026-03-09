package com.tallermecanico.dto.request;

import java.math.BigDecimal;

public class CreateCompetenciaEvaluadaDto {

    private Integer idEvaluacionEmpleado;

    private Integer idCompetencia;

    private Integer evaluacionNota;

    private BigDecimal real;

    // Constructors
    public CreateCompetenciaEvaluadaDto() {
    }

    // Getters and Setters
    public Integer getIdEvaluacionEmpleado() {
        return idEvaluacionEmpleado;
    }

    public void setIdEvaluacionEmpleado(Integer idEvaluacionEmpleado) {
        this.idEvaluacionEmpleado = idEvaluacionEmpleado;
    }

    public Integer getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Integer idCompetencia) {
        this.idCompetencia = idCompetencia;
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
