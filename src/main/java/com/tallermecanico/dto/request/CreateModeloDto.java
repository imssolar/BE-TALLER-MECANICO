package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class CreateModeloDto {

    @NotNull(message = "El ID del modelo es requerido")
    private Integer idModelo;

    @Size(max = 15, message = "El nombre del modelo no puede exceder 15 caracteres")
    private String modelo;

    @Min(value = 0, message = "El kilometraje diario no puede ser negativo")
    private BigDecimal kmDiario;

    @Size(max = 35, message = "Las observaciones no pueden exceder 35 caracteres")
    private String obs;

    // Constructors
    public CreateModeloDto() {
    }

    public CreateModeloDto(Integer idModelo, String modelo, BigDecimal kmDiario, String obs) {
        this.idModelo = idModelo;
        this.modelo = modelo;
        this.kmDiario = kmDiario;
        this.obs = obs;
    }

    // Getters and Setters
    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

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
