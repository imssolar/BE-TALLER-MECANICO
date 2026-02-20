package com.tallermecanico.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class UpdateRepuestoCarroceriaDto {

    @Size(max = 80, message = "El repuesto de carrocería no debe exceder los 80 caracteres")
    private String repuesto;

    @DecimalMin(value = "0", message = "El stock debe ser mayor o igual a 0")
    private BigDecimal stock;

    @Size(max = 15, message = "La unidad no debe exceder los 15 caracteres")
    private String unidad;

    @DecimalMin(value = "0", message = "El valor debe ser mayor o igual a 0")
    private BigDecimal valor;

    @Size(max = 15, message = "El grupo no debe exceder los 15 caracteres")
    private String grupo;

    // Constructors
    public UpdateRepuestoCarroceriaDto() {
    }

    // Getters and Setters
    public String getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(String repuesto) {
        this.repuesto = repuesto;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
