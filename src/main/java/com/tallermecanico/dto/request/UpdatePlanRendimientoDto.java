package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;

public class UpdatePlanRendimientoDto {

    private Integer idMarca;

    private Integer idModelo;

    private Integer idEstado;

    @Min(value = 0, message = "El rendimiento no puede ser negativo")
    private Integer rendimiento;

    // Constructors
    public UpdatePlanRendimientoDto() {
    }

    // Getters and Setters
    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(Integer rendimiento) {
        this.rendimiento = rendimiento;
    }
}
