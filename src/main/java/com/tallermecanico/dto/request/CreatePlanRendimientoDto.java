package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CreatePlanRendimientoDto {

    @NotNull(message = "El ID de la marca es requerido")
    private Integer idMarca;

    @NotNull(message = "El ID del modelo es requerido")
    private Integer idModelo;

    @NotNull(message = "El ID del estado es requerido")
    private Integer idEstado;

    @NotNull(message = "El rendimiento es requerido")
    @Min(value = 0, message = "El rendimiento no puede ser negativo")
    private Integer rendimiento;

    // Constructors
    public CreatePlanRendimientoDto() {
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
