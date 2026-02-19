package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateTallerDto {

    @Size(max = 50, message = "El nombre del taller no debe exceder los 50 caracteres")
    private String taller;

    // Constructors
    public UpdateTallerDto() {
    }

    public UpdateTallerDto(String taller) {
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
