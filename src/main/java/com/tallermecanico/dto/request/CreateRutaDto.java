package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateRutaDto {

    @NotBlank(message = "El nombre de la ruta es requerido")
    @Size(min = 3, max = 50, message = "El nombre de la ruta debe tener entre 3 y 50 caracteres")
    private String ruta;

    // Constructors
    public CreateRutaDto() {
    }

    public CreateRutaDto(String ruta) {
        this.ruta = ruta;
    }

    // Getters and Setters
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
