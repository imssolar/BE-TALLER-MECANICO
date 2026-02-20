package com.tallermecanico.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class UpdateRepuestoDto {

    @Size(max = 50, message = "El repuesto no debe exceder los 50 caracteres")
    private String repuesto;

    @DecimalMin(value = "0", message = "El costo debe ser mayor o igual a 0")
    private BigDecimal costo;

    @Min(value = 0, message = "El stock debe ser mayor o igual a 0")
    private Integer stock;

    // Constructors
    public UpdateRepuestoDto() {
    }

    // Getters and Setters
    public String getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(String repuesto) {
        this.repuesto = repuesto;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
