package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateNacionalidadDto {

    @NotBlank(message = "La nacionalidad es requerida")
    @Size(max = 50, message = "La nacionalidad no debe exceder los 50 caracteres")
    private String nacionalidad;

    // Constructors
    public CreateNacionalidadDto() {
    }

    public CreateNacionalidadDto(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    // Getters and Setters
    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
