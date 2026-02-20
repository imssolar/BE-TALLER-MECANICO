package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateMedicionDto {

    @Size(max = 50, message = "La medición no debe exceder los 50 caracteres")
    private String medicion;

    // Constructors
    public UpdateMedicionDto() {
    }

    // Getters and Setters
    public String getMedicion() {
        return medicion;
    }

    public void setMedicion(String medicion) {
        this.medicion = medicion;
    }
}
