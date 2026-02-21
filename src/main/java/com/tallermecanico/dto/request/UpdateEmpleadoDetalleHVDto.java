package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class UpdateEmpleadoDetalleHVDto {

    @Size(max = 12, message = "El rut no debe exceder los 12 caracteres")
    private String rut;

    @Size(max = 30, message = "La observacion no debe exceder los 30 caracteres")
    private String observacion;

    private LocalDateTime fechaHora;

    @Size(max = 200, message = "El comentario no debe exceder los 200 caracteres")
    private String comentario;

    // Constructors
    public UpdateEmpleadoDetalleHVDto() {
    }

    // Getters and Setters
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
