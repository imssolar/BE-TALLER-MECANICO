package com.tallermecanico.dto.request;

import com.tallermecanico.enums.TipoEntrega;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class UpdateDetalleEntregaDto {

    private Integer idEmpleado;

    private TipoEntrega tipoEntrega;

    private Integer idEquipamiento;

    private Integer idHerramienta;

    private LocalDate fechaEntrega;

    private Integer idEntregadoPor;

    private Short cantidad;

    @DecimalMin(value = "0", message = "El costo debe ser mayor o igual a 0")
    private BigDecimal costo;

    private Boolean devuelto;

    private LocalDate fechaDevolucion;

    private Integer cantidadDevuelta;

    private Integer pendiente;

    @Size(max = 10, message = "El próximo cambio no debe exceder los 10 caracteres")
    private String proximoCambio;

    @Size(max = 20, message = "El tipo de devolución no debe exceder los 20 caracteres")
    private String tipoDevolucion;

    // Constructors
    public UpdateDetalleEntregaDto() {
    }

    // Getters and Setters
    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public TipoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(TipoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public Integer getIdEquipamiento() {
        return idEquipamiento;
    }

    public void setIdEquipamiento(Integer idEquipamiento) {
        this.idEquipamiento = idEquipamiento;
    }

    public Integer getIdHerramienta() {
        return idHerramienta;
    }

    public void setIdHerramienta(Integer idHerramienta) {
        this.idHerramienta = idHerramienta;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Integer getIdEntregadoPor() {
        return idEntregadoPor;
    }

    public void setIdEntregadoPor(Integer idEntregadoPor) {
        this.idEntregadoPor = idEntregadoPor;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
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

    public Integer getCantidadDevuelta() {
        return cantidadDevuelta;
    }

    public void setCantidadDevuelta(Integer cantidadDevuelta) {
        this.cantidadDevuelta = cantidadDevuelta;
    }

    public Integer getPendiente() {
        return pendiente;
    }

    public void setPendiente(Integer pendiente) {
        this.pendiente = pendiente;
    }

    public String getProximoCambio() {
        return proximoCambio;
    }

    public void setProximoCambio(String proximoCambio) {
        this.proximoCambio = proximoCambio;
    }

    public String getTipoDevolucion() {
        return tipoDevolucion;
    }

    public void setTipoDevolucion(String tipoDevolucion) {
        this.tipoDevolucion = tipoDevolucion;
    }
}
