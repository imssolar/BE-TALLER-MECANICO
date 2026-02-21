package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class CreateHerramientasPlanDto {

    private String idHerramienta;

    @Size(max = 25, message = "El patron no puede exceder 25 caracteres")
    private String patron;

    private LocalDate fechaRevision;

    @Size(max = 15, message = "El estado de mantencion no puede exceder 15 caracteres")
    private String estadoMantencion;

    @Size(max = 25, message = "El patron1 no puede exceder 25 caracteres")
    private String patron1;

    @Size(max = 25, message = "La herramienta1 no puede exceder 25 caracteres")
    private String herramienta1;

    @Size(max = 25, message = "El patron2 no puede exceder 25 caracteres")
    private String patron2;

    @Size(max = 25, message = "La herramienta2 no puede exceder 25 caracteres")
    private String herramienta2;

    @Size(max = 25, message = "El patron3 no puede exceder 25 caracteres")
    private String patron3;

    @Size(max = 25, message = "La herramienta3 no puede exceder 25 caracteres")
    private String herramienta3;

    @Size(max = 250, message = "Las observaciones no pueden exceder 250 caracteres")
    private String observaciones;

    @Size(max = 50, message = "El tecnico responsable no puede exceder 50 caracteres")
    private String tecResponsable;

    private Boolean estadoHerramienta;

    // Constructors
    public CreateHerramientasPlanDto() {
    }

    // Getters and Setters
    public String getIdHerramienta() {
        return idHerramienta;
    }

    public void setIdHerramienta(String idHerramienta) {
        this.idHerramienta = idHerramienta;
    }

    public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
        this.patron = patron;
    }

    public LocalDate getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(LocalDate fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getEstadoMantencion() {
        return estadoMantencion;
    }

    public void setEstadoMantencion(String estadoMantencion) {
        this.estadoMantencion = estadoMantencion;
    }

    public String getPatron1() {
        return patron1;
    }

    public void setPatron1(String patron1) {
        this.patron1 = patron1;
    }

    public String getHerramienta1() {
        return herramienta1;
    }

    public void setHerramienta1(String herramienta1) {
        this.herramienta1 = herramienta1;
    }

    public String getPatron2() {
        return patron2;
    }

    public void setPatron2(String patron2) {
        this.patron2 = patron2;
    }

    public String getHerramienta2() {
        return herramienta2;
    }

    public void setHerramienta2(String herramienta2) {
        this.herramienta2 = herramienta2;
    }

    public String getPatron3() {
        return patron3;
    }

    public void setPatron3(String patron3) {
        this.patron3 = patron3;
    }

    public String getHerramienta3() {
        return herramienta3;
    }

    public void setHerramienta3(String herramienta3) {
        this.herramienta3 = herramienta3;
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

    public Boolean getEstadoHerramienta() {
        return estadoHerramienta;
    }

    public void setEstadoHerramienta(Boolean estadoHerramienta) {
        this.estadoHerramienta = estadoHerramienta;
    }
}
