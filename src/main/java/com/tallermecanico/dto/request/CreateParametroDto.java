package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class CreateParametroDto {

    @NotBlank(message = "La descripción del parámetro es requerida")
    @Size(max = 50, message = "La descripción del parámetro no debe exceder los 50 caracteres")
    private String descripcion;

    private BigDecimal valor;

    // Constructors
    public CreateParametroDto() {
    }

    // Getters and Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
