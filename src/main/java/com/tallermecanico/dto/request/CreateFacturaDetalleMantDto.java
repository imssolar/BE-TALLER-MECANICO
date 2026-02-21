package com.tallermecanico.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class CreateFacturaDetalleMantDto {

    @NotNull(message = "El id de la factura es requerido")
    private Integer idFactura;

    @Size(max = 10, message = "El id del repuesto no puede exceder 10 caracteres")
    private String idRepuesto;

    @Size(max = 80, message = "El repuesto no puede exceder 80 caracteres")
    private String repuesto;

    @DecimalMin(value = "0", message = "La cantidad debe ser mayor o igual a 0")
    private BigDecimal cantidad;

    @DecimalMin(value = "0", message = "El precio debe ser mayor o igual a 0")
    private BigDecimal precio;

    // Constructors
    public CreateFacturaDetalleMantDto() {
    }

    // Getters and Setters
    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(String idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public String getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(String repuesto) {
        this.repuesto = repuesto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
