package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateTrabajosElectDto {

    @NotBlank(message = "El tipo de trabajo eléctrico es requerido")
    @Size(max = 100, message = "El tipo de trabajo eléctrico no puede exceder 100 caracteres")
    private String tipoTE;

    // Constructors
    public CreateTrabajosElectDto() {
    }

    public CreateTrabajosElectDto(String tipoTE) {
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
