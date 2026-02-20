package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateLiquidoDto {

    @NotBlank(message = "El nombre del liquido es requerido")
    @Size(max = 30, message = "El nombre del liquido no debe exceder los 30 caracteres")
    private String liquido;

    // Constructors
    public CreateLiquidoDto() {
    }

    // Getters and Setters
    public String getLiquido() {
        return liquido;
    }

    public void setLiquido(String liquido) {
        this.liquido = liquido;
    }
}
