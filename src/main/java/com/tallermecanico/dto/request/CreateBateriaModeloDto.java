package com.tallermecanico.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class CreateBateriaModeloDto {

    @NotBlank(message = "El modelo de batería es requerido")
    @Size(max = 20, message = "El modelo de batería no debe exceder los 20 caracteres")
    private String modelo;

    @DecimalMin(value = "0", message = "El rendimiento debe ser mayor o igual a 0")
    private BigDecimal rendimiento;

    // Constructors
    public CreateBateriaModeloDto() {
    }

    // Getters and Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public BigDecimal getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(BigDecimal rendimiento) {
        this.rendimiento = rendimiento;
    }
}
