package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateResponsableCierreDto {

    @Size(max = 50, message = "El nombre del responsable de cierre no debe exceder los 50 caracteres")
    private String nombre;

    // Constructors
    public UpdateResponsableCierreDto() {
    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
