package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateComunaDto {

    @Size(max = 50, message = "El nombre de la comuna no debe exceder los 50 caracteres")
    private String comuna;

    // Constructors
    public UpdateComunaDto() {
    }

    public UpdateComunaDto(String comuna) {
        this.comuna = comuna;
    }

    // Getters and Setters
    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
}
