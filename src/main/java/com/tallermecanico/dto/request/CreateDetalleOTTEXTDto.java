package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class CreateDetalleOTTEXTDto {

    private Integer idOtTallerExt;

    private Short cantidad;

    @Size(max = 80, message = "La descripcion no puede exceder 80 caracteres")
    private String descripcion;

    @Min(value = 0, message = "El precio no puede ser negativo")
    private Integer precio;

    private Short tipo;

    // Constructors
    public CreateDetalleOTTEXTDto() {
    }

    // Getters and Setters
    public Integer getIdOtTallerExt() {
        return idOtTallerExt;
    }

    public void setIdOtTallerExt(Integer idOtTallerExt) {
        this.idOtTallerExt = idOtTallerExt;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Short getTipo() {
        return tipo;
    }

    public void setTipo(Short tipo) {
        this.tipo = tipo;
    }
}
