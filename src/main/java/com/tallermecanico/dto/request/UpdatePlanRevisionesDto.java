package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UpdatePlanRevisionesDto {

    private Integer idBus;

    @Size(max = 10, message = "El tipo no puede exceder 10 caracteres")
    private String tipo;

    private LocalDate fechaRevision;

    @Size(max = 10, message = "El estado no puede exceder 10 caracteres")
    private String estado;

    // Constructors
    public UpdatePlanRevisionesDto() {
    }

    // Getters and Setters
    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
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
}
