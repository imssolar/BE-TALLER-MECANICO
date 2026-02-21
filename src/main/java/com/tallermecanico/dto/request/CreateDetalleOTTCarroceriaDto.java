package com.tallermecanico.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class CreateDetalleOTTCarroceriaDto {

    private Integer idOtCarroceria;

    @Size(max = 8, message = "El código no puede exceder 8 caracteres")
    private String codigo;

    @Size(max = 80, message = "El insumo/repuesto no puede exceder 80 caracteres")
    private String insumoRepuesto;

    @Size(max = 15, message = "La unidad no puede exceder 15 caracteres")
    private String unidad;

    @DecimalMin(value = "0", message = "La cantidad debe ser mayor o igual a 0")
    private BigDecimal cantidad;

    @DecimalMin(value = "0", message = "El valor debe ser mayor o igual a 0")
    private BigDecimal valor;

    @Size(max = 15, message = "El área no puede exceder 15 caracteres")
    private String area;

    // Constructors
    public CreateDetalleOTTCarroceriaDto() {
    }

    // Getters and Setters
    public Integer getIdOtCarroceria() {
        return idOtCarroceria;
    }

    public void setIdOtCarroceria(Integer idOtCarroceria) {
        this.idOtCarroceria = idOtCarroceria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getInsumoRepuesto() {
        return insumoRepuesto;
    }

    public void setInsumoRepuesto(String insumoRepuesto) {
        this.insumoRepuesto = insumoRepuesto;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
