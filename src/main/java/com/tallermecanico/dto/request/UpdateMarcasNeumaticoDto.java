package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateMarcasNeumaticoDto {

    @Size(max = 15, message = "La marca no puede exceder 15 caracteres")
    private String marca;

    // Constructors
    public UpdateMarcasNeumaticoDto() {
    }

    public UpdateMarcasNeumaticoDto(String marca) {
        this.marca = marca;
    }

    // Getters and Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
