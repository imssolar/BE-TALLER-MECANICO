package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateEstadosNeumaticoDto {

    @NotBlank(message = "El estado es requerido")
    @Size(max = 15, message = "El estado no puede exceder 15 caracteres")
    private String estado;

    // Constructors
    public CreateEstadosNeumaticoDto() {
    }

    public CreateEstadosNeumaticoDto(String estado) {
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
