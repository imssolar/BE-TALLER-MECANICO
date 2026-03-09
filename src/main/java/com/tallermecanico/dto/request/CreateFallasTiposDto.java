package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateFallasTiposDto {

    @NotBlank(message = "El ID de falla es obligatorio")
    private String idFalla;

    @NotBlank(message = "El tipo de falla es obligatorio")
    @Size(min = 3, max = 50, message = "El tipo de falla debe tener entre 3 y 50 caracteres")
    private String tipoFalla;

    public CreateFallasTiposDto(String idFalla, String tipoFalla) {
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
