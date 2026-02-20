package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;

public class UpdateMantencionDto {

    private Integer idItem;

    private Integer idModelo;

    @Min(value = 0, message = "El kilometraje no puede ser negativo")
    private Integer km;

    // Constructors
    public UpdateMantencionDto() {
    }

    // Getters and Setters
    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }
}
