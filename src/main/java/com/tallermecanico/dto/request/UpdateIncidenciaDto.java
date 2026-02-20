package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateIncidenciaDto {

    @Size(max = 30, message = "El nombre de la incidencia no debe exceder los 30 caracteres")
    private String incidencia;

    // Constructors
    public UpdateIncidenciaDto() {
    }

    // Getters and Setters
    public String getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(String incidencia) {
        this.incidencia = incidencia;
    }
}
