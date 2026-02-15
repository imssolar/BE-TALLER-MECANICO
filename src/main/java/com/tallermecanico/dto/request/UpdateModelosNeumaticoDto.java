package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateModelosNeumaticoDto {

    @Size(max = 15, message = "El modelo no puede exceder 15 caracteres")
    private String modelo;

    // Constructors
    public UpdateModelosNeumaticoDto() {
    }

    public UpdateModelosNeumaticoDto(String modelo) {
        this.modelo = modelo;
    }

    // Getters and Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
