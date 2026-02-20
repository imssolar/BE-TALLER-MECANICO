package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateGravedadCarroceriaDto {

    @NotBlank(message = "La gravedad de carrocería es requerida")
    @Size(max = 20, message = "La gravedad de carrocería no debe exceder los 20 caracteres")
    private String gravedad;

    // Constructors
    public CreateGravedadCarroceriaDto() {
    }

    // Getters and Setters
    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }
}
