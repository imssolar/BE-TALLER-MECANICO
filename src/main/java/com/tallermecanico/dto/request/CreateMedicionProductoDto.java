package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateMedicionProductoDto {

    @NotBlank(message = "El producto de medición es requerido")
    @Size(max = 50, message = "El producto de medición no debe exceder los 50 caracteres")
    private String producto;

    // Constructors
    public CreateMedicionProductoDto() {
    }

    // Getters and Setters
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}
