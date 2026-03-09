package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateGlosaDto {

    @Size(max = 100, message = "La glosa no puede exceder 100 caracteres")
    private String glosa;

    // Constructors
    public UpdateGlosaDto() {
    }

    public UpdateGlosaDto(String glosa) {
        this.glosa = glosa;
    }

    // Getters and Setters
    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }
}
