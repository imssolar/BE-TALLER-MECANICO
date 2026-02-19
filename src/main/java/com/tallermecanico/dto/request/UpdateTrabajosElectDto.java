package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateTrabajosElectDto {

    @Size(max = 100, message = "El tipo de trabajo eléctrico no puede exceder 100 caracteres")
    private String tipoTE;

    // Constructors
    public UpdateTrabajosElectDto() {
    }

    public UpdateTrabajosElectDto(String tipoTE) {
        this.tipoTE = tipoTE;
    }

    // Getters and Setters
    public String getTipoTE() {
        return tipoTE;
    }

    public void setTipoTE(String tipoTE) {
        this.tipoTE = tipoTE;
    }
}
