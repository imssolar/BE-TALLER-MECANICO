package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class UpdateRevisionDto {

    private Integer idPlanRevisiones;

    private Integer idBus;

    private LocalDate fechaRevision;

    @Min(value = 0, message = "El kilometraje no puede ser negativo")
    private Long km;

    @Size(max = 10, message = "El tipo no puede exceder 10 caracteres")
    private String tipo;

    private LocalDate fechaControl;

    @Size(max = 10, message = "El estado no puede exceder 10 caracteres")
    private String estado;

    @Size(max = 10, message = "La instancia no puede exceder 10 caracteres")
    private String instancia;

    @Size(max = 50, message = "Las observaciones no pueden exceder 50 caracteres")
    private String observaciones;

    // Constructors
    public UpdateRevisionDto() {
    }

    // Getters and Setters
    public Integer getIdPlanRevisiones() {
        return idPlanRevisiones;
    }

    public void setIdPlanRevisiones(Integer idPlanRevisiones) {
        this.idPlanRevisiones = idPlanRevisiones;
    }

    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    public LocalDate getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(LocalDate fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public Long getKm() {
        return km;
    }

    public void setKm(Long km) {
        this.km = km;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaControl() {
        return fechaControl;
    }

    public void setFechaControl(LocalDate fechaControl) {
        this.fechaControl = fechaControl;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
