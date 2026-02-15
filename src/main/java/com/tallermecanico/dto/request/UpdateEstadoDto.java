package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotNull;

public class UpdateEstadoDto {

    @NotNull(message = "El estado operativo es requerido")
    private Boolean operativaB;

    // Constructors
    public UpdateEstadoDto() {
    }

    public UpdateEstadoDto(Boolean operativaB) {
        this.operativaB = operativaB;
    }

    // Getters and Setters
    public Boolean getOperativaB() {
        return operativaB;
    }

    public void setOperativaB(Boolean operativaB) {
        this.operativaB = operativaB;
    }
}
