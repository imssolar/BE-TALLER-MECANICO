package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class UpdateMantencionMovilDto {

    @Size(max = 30, message = "El item de mantención no debe exceder los 30 caracteres")
    private String item;

    @Min(value = 0, message = "El kilometraje debe ser mayor o igual a 0")
    private Integer km;

    // Constructors
    public UpdateMantencionMovilDto() {
    }

    // Getters and Setters
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }
}
