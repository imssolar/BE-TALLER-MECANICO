package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateGravedadPinturaDto {

    @NotBlank(message = "La gravedad de pintura es requerida")
    @Size(max = 20, message = "La gravedad de pintura no debe exceder los 20 caracteres")
    private String gravedad;

    // Constructors
    public CreateGravedadPinturaDto() {
    }

    // Getters and Setters
    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }
}
