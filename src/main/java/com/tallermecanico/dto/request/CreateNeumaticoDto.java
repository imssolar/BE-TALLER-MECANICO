package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateNeumaticoDto {

    @NotNull(message = "El ID del bus es requerido")
    private Integer idBus;

    @NotNull(message = "El ID del estado es requerido")
    private Integer idEstado;

    @NotNull(message = "El ID de la marca es requerido")
    private Integer idMarca;

    @NotNull(message = "El ID del modelo es requerido")
    private Integer idModelo;

    private LocalDate fechaInstalacion;

    @Min(value = 0, message = "El kilometraje no puede ser negativo")
    private Integer kilometraje;

    @Min(value = 1, message = "La posición debe estar entre 1 y 6")
    @Max(value = 6, message = "La posición debe estar entre 1 y 6")
    private Short posicion;

    @Min(value = 0, message = "La profundidad no puede ser negativa")
    private BigDecimal profundidad;

    @Min(value = 0, message = "La presión no puede ser negativa")
    private Integer presion;

    @Size(max = 15, message = "La marca de fuego no puede exceder 15 caracteres")
    private String marcaFuego;

    @Size(max = 30, message = "Las observaciones no pueden exceder 30 caracteres")
    private String observaciones;

    // Constructors
    public CreateNeumaticoDto() {
    }

    // Getters and Setters
    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public LocalDate getFechaInstalacion() {
        return fechaInstalacion;
    }

    public void setFechaInstalacion(LocalDate fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    public Integer getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Integer kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Short getPosicion() {
        return posicion;
    }

    public void setPosicion(Short posicion) {
        this.posicion = posicion;
    }

    public BigDecimal getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(BigDecimal profundidad) {
        this.profundidad = profundidad;
    }

    public Integer getPresion() {
        return presion;
    }

    public void setPresion(Integer presion) {
        this.presion = presion;
    }

    public String getMarcaFuego() {
        return marcaFuego;
    }

    public void setMarcaFuego(String marcaFuego) {
        this.marcaFuego = marcaFuego;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
