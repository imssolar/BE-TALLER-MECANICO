package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class UpdateInfraestructurasPlanDto {

    private String idInfra;

    @Size(max = 15, message = "El tipo no puede exceder 15 caracteres")
    private String tipo;

    private LocalDate fechaRevision;

    @Size(max = 15, message = "El estado no puede exceder 15 caracteres")
    private String estado;

    @Size(max = 250, message = "Las observaciones no pueden exceder 250 caracteres")
    private String observaciones;

    @Size(max = 50, message = "El tecnico responsable no puede exceder 50 caracteres")
    private String tecResponsable;

    // Constructors
    public UpdateInfraestructurasPlanDto() {
    }

    // Getters and Setters
    public String getIdInfra() {
        return idInfra;
    }

    public void setIdInfra(String idInfra) {
        this.idInfra = idInfra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(LocalDate fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTecResponsable() {
        return tecResponsable;
    }

    public void setTecResponsable(String tecResponsable) {
        this.tecResponsable = tecResponsable;
    }
}
