package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateObservacionHojaVidaDto {

    @Size(max = 30, message = "La observación no debe exceder los 30 caracteres")
    private String observacion;

    // Constructors
    public UpdateObservacionHojaVidaDto() {
    }

    // Getters and Setters
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
