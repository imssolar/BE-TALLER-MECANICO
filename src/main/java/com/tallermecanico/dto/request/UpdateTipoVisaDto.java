package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateTipoVisaDto {

    @Size(max = 50, message = "El tipo de visa no debe exceder los 50 caracteres")
    private String tipoVisa;

    // Constructors
    public UpdateTipoVisaDto() {
    }

    public UpdateTipoVisaDto(String tipoVisa) {
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
