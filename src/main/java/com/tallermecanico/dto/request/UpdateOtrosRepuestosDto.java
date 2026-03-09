package com.tallermecanico.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public class UpdateOtrosRepuestosDto {

    private Integer idOrdenTrabajo;

    private Integer idGlosa;

    private LocalDate fecha;

    @Size(max = 15, message = "El id repuesto no puede exceder 15 caracteres")
    private String idRepuesto;

    @Size(max = 50, message = "El repuesto no puede exceder 50 caracteres")
    private String repuesto;

    @DecimalMin(value = "0", message = "La cantidad no puede ser menor a 0")
    private BigDecimal cantidad;

    @DecimalMin(value = "0", message = "El costo no puede ser menor a 0")
    private BigDecimal costo;

    // Constructors
    public UpdateOtrosRepuestosDto() {
    }

    // Getters and Setters
    public Integer getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public Integer getIdGlosa() {
        return idGlosa;
    }

    public void setIdGlosa(Integer idGlosa) {
        this.idGlosa = idGlosa;
    }

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

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }
}
