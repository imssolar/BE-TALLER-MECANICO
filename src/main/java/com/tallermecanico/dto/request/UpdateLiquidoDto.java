package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateLiquidoDto {

    @Size(max = 30, message = "El nombre del liquido no debe exceder los 30 caracteres")
    private String liquido;

    // Constructors
    public UpdateLiquidoDto() {
    }

    // Getters and Setters
    public String getLiquido() {
        return liquido;
    }

    public void setLiquido(String liquido) {
        this.liquido = liquido;
    }
}
