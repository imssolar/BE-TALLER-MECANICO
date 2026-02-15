package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class UpdateKilometrajeDto {

    @NotNull(message = "El kilometraje es requerido")
    @Min(value = 0, message = "El kilometraje no puede ser negativo")
    private Integer kmB;

    // Constructors
    public UpdateKilometrajeDto() {
    }

    public UpdateKilometrajeDto(Integer kmB) {
        this.kmB = kmB;
    }

    // Getters and Setters
    public Integer getKmB() {
        return kmB;
    }

    public void setKmB(Integer kmB) {
        this.kmB = kmB;
    }
}
