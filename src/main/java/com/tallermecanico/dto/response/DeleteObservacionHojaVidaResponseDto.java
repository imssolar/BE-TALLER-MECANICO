package com.tallermecanico.dto.response;

public class DeleteObservacionHojaVidaResponseDto {

    private String idObs;
    private String observacion;
    private String message;

    // Constructors
    public DeleteObservacionHojaVidaResponseDto() {
    }

    public DeleteObservacionHojaVidaResponseDto(String idObs, String observacion, String message) {
        this.idObs = idObs;
        this.observacion = observacion;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
