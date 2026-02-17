package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateFallasTiposDto {

    private String idFalla;

    @Size(min = 3, max = 50, message = "El tipo de falla debe tener entre 3 y 50 caracteres")
    private String tipoFalla;

    public UpdateFallasTiposDto(String idFalla, String tipoFalla) {
        this.idFalla = idFalla;
        this.tipoFalla = tipoFalla;
    }

    public String getIdFalla() {
        return idFalla;
    }

    public void setIdFalla(String idFalla) {
        this.idFalla = idFalla;
    }

    public String getTipoFalla() {
        return tipoFalla;
    }

    public void setTipoFalla(String tipoFalla) {
        this.tipoFalla = tipoFalla;
    }
}
