package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateSistemaDto {

    @Size(max = 50, message = "El nombre no puede exceder 50 caracteres")
    private String nombre;

    // Constructors
    public UpdateSistemaDto() {
    }

    public UpdateSistemaDto(String nombre) {
        this.nombre = nombre;
    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
