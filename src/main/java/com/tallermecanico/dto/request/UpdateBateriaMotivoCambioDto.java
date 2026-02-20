package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateBateriaMotivoCambioDto {

    @Size(max = 20, message = "El motivo de cambio de batería no debe exceder los 20 caracteres")
    private String motivoCambio;

    // Constructors
    public UpdateBateriaMotivoCambioDto() {
    }

    // Getters and Setters
    public String getMotivoCambio() {
        return motivoCambio;
    }

    public void setMotivoCambio(String motivoCambio) {
        this.motivoCambio = motivoCambio;
    }
}
