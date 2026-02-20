package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;

public class CreateHojaVidaEmpleadoDto {

    private Integer idEmpleado;

    @Size(max = 255, message = "La observación no debe exceder los 255 caracteres")
    private String observacion;

    private LocalDate fecha;

    private LocalTime hora;

    @Size(max = 255, message = "El comentario no debe exceder los 255 caracteres")
    private String comentario;

    // Constructors
    public CreateHojaVidaEmpleadoDto() {
    }

    // Getters and Setters
    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
