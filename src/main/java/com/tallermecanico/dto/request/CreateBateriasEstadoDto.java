package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateBateriasEstadoDto {

    @NotBlank(message = "El estado de batería es requerido")
    @Size(max = 20, message = "El estado de batería no debe exceder los 20 caracteres")
    private String estado;

    // Constructors
    public CreateBateriasEstadoDto() {
    }

    // Getters and Setters
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
