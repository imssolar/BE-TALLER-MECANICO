package com.tallermecanico.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class CreateHerramientaDto {

    @NotBlank(message = "El nombre de la herramienta es requerido")
    @Size(max = 100, message = "El nombre de la herramienta no debe exceder los 100 caracteres")
    private String herramienta;

    @DecimalMin(value = "0", message = "El costo debe ser mayor o igual a 0")
    private BigDecimal costo;

    // Constructors
    public CreateHerramientaDto() {
    }

    public CreateHerramientaDto(String herramienta, BigDecimal costo) {
        this.herramienta = herramienta;
        this.costo = costo;
    }

    // Getters and Setters
    public String getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(String herramienta) {
        this.herramienta = herramienta;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }
}
