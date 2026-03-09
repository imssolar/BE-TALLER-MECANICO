package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class CreateMovimientoBodegaDto {

    @NotBlank(message = "El movimiento es requerido")
    @Size(max = 15, message = "El movimiento no puede exceder 15 caracteres")
    private String movimiento;

    @NotNull(message = "La fecha es requerida")
    private LocalDate fecha;

    @NotNull(message = "El repuesto es requerido")
    private Integer idRepuesto;

    @NotNull(message = "La cantidad es requerida")
    @Min(value = 0, message = "La cantidad debe ser mayor o igual a 0")
    private Integer cantidad;

    @Min(value = 0, message = "El stock actual debe ser mayor o igual a 0")
    private Integer stockActual;

    @Min(value = 0, message = "El nuevo stock debe ser mayor o igual a 0")
    private Integer nuevoStock;

    // Constructors
    public CreateMovimientoBodegaDto() {
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
