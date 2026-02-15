package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class RegistrarEmergenciaDto {

    @NotNull(message = "La fecha de emergencia es requerida")
    private LocalDateTime fechaEmergencia;

    @Size(max = 80, message = "Las observaciones de emergencia no pueden exceder 80 caracteres")
    private String obsEmergenciaB;

    // Constructors
    public RegistrarEmergenciaDto() {
    }

    public RegistrarEmergenciaDto(LocalDateTime fechaEmergencia, String obsEmergenciaB) {
        this.fechaEmergencia = fechaEmergencia;
        this.obsEmergenciaB = obsEmergenciaB;
    }

    // Getters and Setters
    public LocalDateTime getFechaEmergencia() {
        return fechaEmergencia;
    }

    public void setFechaEmergencia(LocalDateTime fechaEmergencia) {
        this.fechaEmergencia = fechaEmergencia;
    }

    public String getObsEmergenciaB() {
        return obsEmergenciaB;
    }

    public void setObsEmergenciaB(String obsEmergenciaB) {
        this.obsEmergenciaB = obsEmergenciaB;
    }
}
