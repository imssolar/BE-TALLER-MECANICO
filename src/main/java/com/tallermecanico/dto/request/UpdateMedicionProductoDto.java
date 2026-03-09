package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateMedicionProductoDto {

    @Size(max = 50, message = "El producto de medición no debe exceder los 50 caracteres")
    private String producto;

    // Constructors
    public UpdateMedicionProductoDto() {
    }

    // Getters and Setters
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}
