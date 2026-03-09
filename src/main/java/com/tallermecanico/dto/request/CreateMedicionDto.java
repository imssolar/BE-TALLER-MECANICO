package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateMedicionDto {

    @NotBlank(message = "La medición es requerida")
    @Size(max = 50, message = "La medición no debe exceder los 50 caracteres")
    private String medicion;

    // Constructors
    public CreateMedicionDto() {
    }

    // Getters and Setters
    public String getMedicion() {
        return medicion;
    }

    public void setMedicion(String medicion) {
        this.medicion = medicion;
    }
}
