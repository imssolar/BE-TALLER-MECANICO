package com.tallermecanico.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class UpdateRepuestosManagerDto {

    private LocalDate fecha;

    @Size(max = 15, message = "El id de repuesto no puede exceder 15 caracteres")
    private String idRepuesto;

    @Size(max = 50, message = "El repuesto no puede exceder 50 caracteres")
    private String repuesto;

    private Integer idGlosa;

    @DecimalMin(value = "0", message = "La cantidad no puede ser negativa")
    private BigDecimal cantidad;

    @DecimalMin(value = "0", message = "El costo no puede ser negativo")
    private BigDecimal costo;

    private Integer idTerminal;

    // Constructors
    public UpdateRepuestosManagerDto() {
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

    public Integer getIdGlosa() {
        return idGlosa;
    }

    public void setIdGlosa(Integer idGlosa) {
        this.idGlosa = idGlosa;
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

    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }
}
