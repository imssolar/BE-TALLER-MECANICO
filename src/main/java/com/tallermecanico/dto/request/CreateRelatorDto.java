package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateRelatorDto {

    @NotBlank(message = "El nombre del relator es requerido")
    @Size(max = 50, message = "El nombre del relator no debe exceder los 50 caracteres")
    private String relator;

    // Constructors
    public CreateRelatorDto() {
    }

    public CreateRelatorDto(String relator) {
        this.relator = relator;
    }

    // Getters and Setters
    public String getRelator() {
        return relator;
    }

    public void setRelator(String relator) {
        this.relator = relator;
    }
}
