package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateTallerDto {

    @NotBlank(message = "El nombre del taller es requerido")
    @Size(max = 50, message = "El nombre del taller no debe exceder los 50 caracteres")
    private String taller;

    // Constructors
    public CreateTallerDto() {
    }

    public CreateTallerDto(String taller) {
        this.taller = taller;
    }

    // Getters and Setters
    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }
}
