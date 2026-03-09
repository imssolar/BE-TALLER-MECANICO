package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateTipoVisaDto {

    @NotBlank(message = "El tipo de visa es requerido")
    @Size(max = 50, message = "El tipo de visa no debe exceder los 50 caracteres")
    private String tipoVisa;

    // Constructors
    public CreateTipoVisaDto() {
    }

    public CreateTipoVisaDto(String tipoVisa) {
        this.tipoVisa = tipoVisa;
    }

    // Getters and Setters
    public String getTipoVisa() {
        return tipoVisa;
    }

    public void setTipoVisa(String tipoVisa) {
        this.tipoVisa = tipoVisa;
    }
}
