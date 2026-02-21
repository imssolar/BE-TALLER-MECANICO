package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class UpdateBateriaDto {

    private Integer idBus;
    private Integer idEstado;
    private Integer idMarca;
    private Integer idModelo;
    private LocalDate fechaInstalacion;

    @Min(value = 0, message = "El kilometraje no puede ser negativo")
    private Integer kilometraje;

    @Min(value = 1, message = "La posicion debe estar entre 1 y 12")
    @Max(value = 12, message = "La posicion debe estar entre 1 y 12")
    private Short posicion;

    private Integer idTerminal;

    @Size(max = 20, message = "El cracn king no puede exceder 20 caracteres")
    private String cracnKing;

    @Size(max = 10, message = "El ID plan rendimiento no puede exceder 10 caracteres")
    private String idPlanRend;

    @Size(max = 10, message = "La marca de fuego no puede exceder 10 caracteres")
    private String marcaFuego;

    private Integer idMotivoCambio;
    private LocalDate fechaCambio;

    @Min(value = 0, message = "El kilometraje de cambio no puede ser negativo")
    private Integer kmCambio;

    @Min(value = 0, message = "La proyeccion no puede ser negativa")
    private Integer proyeccion;

    @Size(max = 20, message = "El visor no puede exceder 20 caracteres")
    private String visor;

    private BigDecimal ohms;

    @Min(value = 0, message = "El CCA salida no puede ser negativo")
    private Integer ccaSalida;

    @Size(max = 50, message = "Las observaciones de baja no pueden exceder 50 caracteres")
    private String observacionesBaja;

    // Constructors
    public UpdateBateriaDto() {
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

    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    public String getCracnKing() {
        return cracnKing;
    }

    public void setCracnKing(String cracnKing) {
        this.cracnKing = cracnKing;
    }

    public String getIdPlanRend() {
        return idPlanRend;
    }

    public void setIdPlanRend(String idPlanRend) {
        this.idPlanRend = idPlanRend;
    }

    public String getMarcaFuego() {
        return marcaFuego;
    }

    public void setMarcaFuego(String marcaFuego) {
        this.marcaFuego = marcaFuego;
    }

    public Integer getIdMotivoCambio() {
        return idMotivoCambio;
    }

    public void setIdMotivoCambio(Integer idMotivoCambio) {
        this.idMotivoCambio = idMotivoCambio;
    }

    public LocalDate getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(LocalDate fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public Integer getKmCambio() {
        return kmCambio;
    }

    public void setKmCambio(Integer kmCambio) {
        this.kmCambio = kmCambio;
    }

    public Integer getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(Integer proyeccion) {
        this.proyeccion = proyeccion;
    }

    public String getVisor() {
        return visor;
    }

    public void setVisor(String visor) {
        this.visor = visor;
    }

    public BigDecimal getOhms() {
        return ohms;
    }

    public void setOhms(BigDecimal ohms) {
        this.ohms = ohms;
    }

    public Integer getCcaSalida() {
        return ccaSalida;
    }

    public void setCcaSalida(Integer ccaSalida) {
        this.ccaSalida = ccaSalida;
    }

    public String getObservacionesBaja() {
        return observacionesBaja;
    }

    public void setObservacionesBaja(String observacionesBaja) {
        this.observacionesBaja = observacionesBaja;
    }
}
