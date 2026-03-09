package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class UpdateMovimientoBodegaDto {

    @Size(max = 15, message = "El movimiento no puede exceder 15 caracteres")
    private String movimiento;

    private LocalDate fecha;

    private Integer idRepuesto;

    @Min(value = 0, message = "La cantidad debe ser mayor o igual a 0")
    private Integer cantidad;

    @Min(value = 0, message = "El stock actual debe ser mayor o igual a 0")
    private Integer stockActual;

    @Min(value = 0, message = "El nuevo stock debe ser mayor o igual a 0")
    private Integer nuevoStock;

    // Constructors
    public UpdateMovimientoBodegaDto() {
    }

    // Getters and Setters
    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(Integer idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }

    public Integer getNuevoStock() {
        return nuevoStock;
    }

    public void setNuevoStock(Integer nuevoStock) {
        this.nuevoStock = nuevoStock;
    }
}
