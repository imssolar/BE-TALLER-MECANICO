package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class CreateCostoSMDto {

    @Size(max = 15, message = "La pauta SM no debe exceder los 15 caracteres")
    private String pautaSm;

    @Size(max = 50, message = "El modelo no debe exceder los 50 caracteres")
    private String modelo;

    @Size(max = 50, message = "El nro OT manager no debe exceder los 50 caracteres")
    private String nroOtManager;

    @Size(max = 150, message = "El producto no debe exceder los 150 caracteres")
    private String producto;

    @Min(value = 0, message = "La cantidad debe ser mayor o igual a 0")
    private Long cantidad;

    @Min(value = 0, message = "El valor promedio debe ser mayor o igual a 0")
    private Long valorPromedio;

    @Min(value = 0, message = "Las horas hombre deben ser mayor o igual a 0")
    private Long horasHombre;

    private LocalDate fechaIngreso;

    // Constructors
    public CreateCostoSMDto() {
    }

    // Getters and Setters
    public String getPautaSm() {
        return pautaSm;
    }

    public void setPautaSm(String pautaSm) {
        this.pautaSm = pautaSm;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNroOtManager() {
        return nroOtManager;
    }

    public void setNroOtManager(String nroOtManager) {
        this.nroOtManager = nroOtManager;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getValorPromedio() {
        return valorPromedio;
    }

    public void setValorPromedio(Long valorPromedio) {
        this.valorPromedio = valorPromedio;
    }

    public Long getHorasHombre() {
        return horasHombre;
    }

    public void setHorasHombre(Long horasHombre) {
        this.horasHombre = horasHombre;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
