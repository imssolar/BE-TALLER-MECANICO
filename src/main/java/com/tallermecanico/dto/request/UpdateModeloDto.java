package com.tallermecanico.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class UpdateModeloDto {

    @Size(max = 100, message = "El nombre del modelo no debe exceder los 100 caracteres")
    private String modelo;

    @DecimalMin(value = "0", message = "El kilometraje diario debe ser mayor o igual a 0")
    private BigDecimal kmDiario;

    @Size(max = 255, message = "Las observaciones no deben exceder los 255 caracteres")
    private String observaciones;

    // Constructors
    public UpdateModeloDto() {
    }

    public UpdateModeloDto(String modelo, BigDecimal kmDiario, String observaciones) {
        this.modelo = modelo;
        this.kmDiario = kmDiario;
        this.observaciones = observaciones;
    }

    // Getters and Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public BigDecimal getKmDiario() {
        return kmDiario;
    }

    public void setKmDiario(BigDecimal kmDiario) {
        this.kmDiario = kmDiario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
