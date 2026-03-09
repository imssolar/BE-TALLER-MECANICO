package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateGravedadPinturaDto {

    @Size(max = 20, message = "La gravedad de pintura no debe exceder los 20 caracteres")
    private String gravedad;

    // Constructors
    public UpdateGravedadPinturaDto() {
    }

    // Getters and Setters
    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }
}
