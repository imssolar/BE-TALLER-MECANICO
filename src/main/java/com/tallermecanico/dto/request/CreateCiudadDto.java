package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateCiudadDto {

    @NotBlank(message = "El nombre de la ciudad es requerido")
    @Size(max = 50, message = "El nombre de la ciudad no debe exceder los 50 caracteres")
    private String ciudad;

    // Constructors
    public CreateCiudadDto() {
    }

    public CreateCiudadDto(String ciudad) {
        this.ciudad = ciudad;
    }

    // Getters and Setters
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
