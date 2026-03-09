package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class CreateMovilDto {

    @NotBlank(message = "La patente es requerida")
    @Size(max = 7, message = "La patente no puede exceder 7 caracteres")
    private String patente;

    @Size(max = 50, message = "La marca no puede exceder 50 caracteres")
    private String marca;

    @Size(max = 50, message = "El modelo no puede exceder 50 caracteres")
    private String modelo;

    @Size(max = 50, message = "El responsable no puede exceder 50 caracteres")
    private String responsable;

    private Integer anoFabricacion;

    private Boolean operativa;

    private Integer km;

    private LocalDate fechaRevisionTecnica;

    private LocalDate fechaRevisionGases;

    // Constructors
    public CreateMovilDto() {
    }

    // Getters and Setters
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Integer getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(Integer anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    public Boolean getOperativa() {
        return operativa;
    }

    public void setOperativa(Boolean operativa) {
        this.operativa = operativa;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public LocalDate getFechaRevisionTecnica() {
        return fechaRevisionTecnica;
    }

    public void setFechaRevisionTecnica(LocalDate fechaRevisionTecnica) {
        this.fechaRevisionTecnica = fechaRevisionTecnica;
    }

    public LocalDate getFechaRevisionGases() {
        return fechaRevisionGases;
    }

    public void setFechaRevisionGases(LocalDate fechaRevisionGases) {
        this.fechaRevisionGases = fechaRevisionGases;
    }
}
