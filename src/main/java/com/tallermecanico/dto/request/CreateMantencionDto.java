package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CreateMantencionDto {

    @NotNull(message = "El ítem de mantención es requerido")
    private Integer idItem;

    @NotNull(message = "El modelo es requerido")
    private Integer idModelo;

    @NotNull(message = "El kilometraje es requerido")
    @Min(value = 0, message = "El kilometraje no puede ser negativo")
    private Integer km;

    // Constructors
    public CreateMantencionDto() {
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
