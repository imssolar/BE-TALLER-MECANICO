package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateMotivoCambioDto {

    @Size(max = 100, message = "El motivo de cambio no debe exceder los 100 caracteres")
    private String motivo;

    // Constructors
    public UpdateMotivoCambioDto() {
    }

    public UpdateMotivoCambioDto(String motivo) {
        this.motivo = motivo;
    }

    // Getters and Setters
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
