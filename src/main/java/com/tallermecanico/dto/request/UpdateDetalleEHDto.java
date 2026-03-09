package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class UpdateDetalleEHDto {

    @Size(max = 13, message = "El rut no puede exceder 13 caracteres")
    private String rut;

    @Size(max = 20, message = "El tipo de entrega no puede exceder 20 caracteres")
    private String tipoEntrega;

    @Size(max = 50, message = "El equipo/herramienta no puede exceder 50 caracteres")
    private String equipHerram;

    private LocalDate fechaEntrega;

    @Size(max = 30, message = "El campo entregado por no puede exceder 30 caracteres")
    private String entregadoPor;

    private Short cantidad;

    private Integer costo;

    private Boolean devuelto;

    private LocalDate fechaDevolucion;

    private Integer cantDevuelta;

    private Integer pendiente;

    @Size(max = 10, message = "El próximo cambio no puede exceder 10 caracteres")
    private String proxCambio;

    @Size(max = 20, message = "El tipo de devolución no puede exceder 20 caracteres")
    private String tipoDev;

    // Constructors
    public UpdateDetalleEHDto() {
    }

    // Getters and Setters
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public String getEquipHerram() {
        return equipHerram;
    }

    public void setEquipHerram(String equipHerram) {
        this.equipHerram = equipHerram;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEntregadoPor() {
        return entregadoPor;
    }

    public void setEntregadoPor(String entregadoPor) {
        this.entregadoPor = entregadoPor;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Boolean getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Integer getCantDevuelta() {
        return cantDevuelta;
    }

    public void setCantDevuelta(Integer cantDevuelta) {
        this.cantDevuelta = cantDevuelta;
    }

    public Integer getPendiente() {
        return pendiente;
    }

    public void setPendiente(Integer pendiente) {
        this.pendiente = pendiente;
    }

    public String getProxCambio() {
        return proxCambio;
    }

    public void setProxCambio(String proxCambio) {
        this.proxCambio = proxCambio;
    }

    public String getTipoDev() {
        return tipoDev;
    }

    public void setTipoDev(String tipoDev) {
        this.tipoDev = tipoDev;
    }
}
