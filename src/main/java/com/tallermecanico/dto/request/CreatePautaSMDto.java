package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreatePautaSMDto {

    @NotBlank(message = "La pauta SM es requerida")
    @Size(max = 10, message = "La pauta SM no debe exceder los 10 caracteres")
    private String pauta;

    // Constructors
    public CreatePautaSMDto() {
    }

    // Getters and Setters
    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }
}
