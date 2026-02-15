package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class UpdateModeloDto {

    @Size(max = 15, message = "El nombre del modelo no puede exceder 15 caracteres")
    private String modelo;

    @Min(value = 0, message = "El kilometraje diario no puede ser negativo")
    private BigDecimal kmDiario;

    @Size(max = 35, message = "Las observaciones no pueden exceder 35 caracteres")
    private String obs;

    // Constructors
    public UpdateModeloDto() {
    }

    public UpdateModeloDto(String modelo, BigDecimal kmDiario, String obs) {
        this.modelo = modelo;
        this.kmDiario = kmDiario;
        this.obs = obs;
    }

    // Getters and Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo != null ? modelo.trim().toUpperCase() : null;
    }

    public BigDecimal getKmDiario() {
        return kmDiario;
    }

    public void setKmDiario(BigDecimal kmDiario) {
        this.kmDiario = kmDiario;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
