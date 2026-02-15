package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateEstadosNeumaticoDto {

    @Size(max = 15, message = "El estado no puede exceder 15 caracteres")
    private String estado;

    // Constructors
    public UpdateEstadosNeumaticoDto() {
    }

    public UpdateEstadosNeumaticoDto(String estado) {
        this.estado = estado;
    }

    // Getters and Setters
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
