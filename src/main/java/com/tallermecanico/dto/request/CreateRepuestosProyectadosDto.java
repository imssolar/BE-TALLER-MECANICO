package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class CreateRepuestosProyectadosDto {

    private LocalDate fecha;

    @Size(max = 15, message = "El id repuesto no puede exceder 15 caracteres")
    private String idRepuesto;

    @Size(max = 50, message = "El repuesto no puede exceder 50 caracteres")
    private String repuesto;

    private Integer cantidad;

    private Integer unitario;

    private Integer total;

    // Constructors
    public CreateRepuestosProyectadosDto() {
    }

    // Getters and Setters
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(String idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public String getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(String repuesto) {
        this.repuesto = repuesto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getUnitario() {
        return unitario;
    }

    public void setUnitario(Integer unitario) {
        this.unitario = unitario;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
