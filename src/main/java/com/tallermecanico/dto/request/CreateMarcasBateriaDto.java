package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateMarcasBateriaDto {

    @NotBlank(message = "La marca es requerida")
    @Size(max = 20, message = "La marca no puede exceder 20 caracteres")
    private String marca;

    // Constructors
    public CreateMarcasBateriaDto() {
    }

    public CreateMarcasBateriaDto(String marca) {
        this.marca = marca;
    }

    // Getters and Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca != null ? marca.trim().toUpperCase() : null;
    }
}
