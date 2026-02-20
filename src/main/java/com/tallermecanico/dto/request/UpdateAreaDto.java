package com.tallermecanico.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class UpdateAreaDto {

    @Size(max = 50, message = "El nombre del área no debe exceder los 50 caracteres")
    private String area;

    @DecimalMin(value = "0", message = "La ponderación debe ser mayor o igual a 0")
    private BigDecimal ponderacion;

    // Constructors
    public UpdateAreaDto() {
    }

    // Getters and Setters
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public BigDecimal getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(BigDecimal ponderacion) {
        this.ponderacion = ponderacion;
    }
}
