package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateResponsableDto {

    @NotBlank(message = "El nombre del responsable es requerido")
    @Size(max = 25, message = "El nombre del responsable no debe exceder los 25 caracteres")
    private String responsable;

    // Constructors
    public CreateResponsableDto() {
    }

    // Getters and Setters
    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
}
