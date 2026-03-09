package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateRelatorDto {

    @Size(max = 50, message = "El nombre del relator no debe exceder los 50 caracteres")
    private String relator;

    // Constructors
    public UpdateRelatorDto() {
    }

    public UpdateRelatorDto(String relator) {
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
