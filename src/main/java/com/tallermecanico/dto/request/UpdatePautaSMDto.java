package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdatePautaSMDto {

    @Size(max = 10, message = "La pauta SM no debe exceder los 10 caracteres")
    private String pauta;

    // Constructors
    public UpdatePautaSMDto() {
    }

    // Getters and Setters
    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }
}
