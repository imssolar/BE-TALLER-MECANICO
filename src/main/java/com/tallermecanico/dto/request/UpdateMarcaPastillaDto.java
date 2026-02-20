package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateMarcaPastillaDto {

    @Size(max = 50, message = "El nombre de la marca de pastilla no debe exceder los 50 caracteres")
    private String marcaPastilla;

    // Constructors
    public UpdateMarcaPastillaDto() {
    }

    // Getters and Setters
    public String getMarcaPastilla() {
        return marcaPastilla;
    }

    public void setMarcaPastilla(String marcaPastilla) {
        this.marcaPastilla = marcaPastilla;
    }
}
