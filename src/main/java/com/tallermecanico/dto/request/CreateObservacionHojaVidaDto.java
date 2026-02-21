package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateObservacionHojaVidaDto {

    @NotBlank(message = "El id de observación es requerido")
    @Size(max = 3, message = "El id de observación no debe exceder los 3 caracteres")
    private String idObs;

    @Size(max = 30, message = "La observación no debe exceder los 30 caracteres")
    private String observacion;

    // Constructors
    public CreateObservacionHojaVidaDto() {
    }

    // Getters and Setters
    public String getIdObs() {
        return idObs;
    }

    public void setIdObs(String idObs) {
        this.idObs = idObs;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
