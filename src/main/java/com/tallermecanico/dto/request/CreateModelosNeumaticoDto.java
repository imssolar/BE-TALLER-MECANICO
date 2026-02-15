package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateModelosNeumaticoDto {

    @NotBlank(message = "El modelo es requerido")
    @Size(max = 15, message = "El modelo no puede exceder 15 caracteres")
    private String modelo;

    // Constructors
    public CreateModelosNeumaticoDto() {
    }

    public CreateModelosNeumaticoDto(String modelo) {
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
