package com.tallermecanico.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class CreateEquipamientoDto {

    @NotBlank(message = "El nombre del equipamiento es requerido")
    @Size(max = 100, message = "El nombre del equipamiento no debe exceder los 100 caracteres")
    private String equipamiento;

    @NotNull(message = "El costo es requerido")
    @DecimalMin(value = "0", message = "El costo debe ser mayor o igual a 0")
    private BigDecimal costo;

    private BigDecimal cambio;

    // Constructors
    public CreateEquipamientoDto() {
    }

    public CreateEquipamientoDto(String equipamiento, BigDecimal costo, BigDecimal cambio) {
        this.equipamiento = equipamiento;
        this.costo = costo;
        this.cambio = cambio;
    }

    // Getters and Setters
    public String getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(String equipamiento) {
        this.equipamiento = equipamiento;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getCambio() {
        return cambio;
    }

    public void setCambio(BigDecimal cambio) {
        this.cambio = cambio;
    }
}
