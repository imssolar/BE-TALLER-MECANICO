package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateMarcaPastillaDto {

    @NotBlank(message = "El nombre de la marca de pastilla es requerido")
    @Size(max = 50, message = "El nombre de la marca de pastilla no debe exceder los 50 caracteres")
    private String marcaPastilla;

    // Constructors
    public CreateMarcaPastillaDto() {
    }

    // Getters and Setters
    public String getMarcaPastilla() {
        return marcaPastilla;
    }

    public void setMarcaPastilla(String marcaPastilla) {
        this.marcaPastilla = marcaPastilla;
    }
}
