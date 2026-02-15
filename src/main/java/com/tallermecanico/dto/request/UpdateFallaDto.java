package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateFallaDto {

    @Size(min = 3, max= 25, message = "El campo debe tener entre 3 y 25 caracteres")
    @NotBlank(message = "El campo es requerido")
    private String falla;

    public UpdateFallaDto(String falla) {
        this.falla = falla;
    }

    public String getFalla() {
        return falla;
    }

    public void setFalla(String falla) {
        this.falla = falla;
    }
}
