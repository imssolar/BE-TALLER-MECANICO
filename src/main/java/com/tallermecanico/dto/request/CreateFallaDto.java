package com.tallermecanico.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateFallaDto {
    @NotBlank(message = "El código de ID falla es obligatorio")
    @Size(min = 3, max = 3, message = "El ID de falla debe tener exactamente 3 caracteres")
    private String idFalla;

    @Size(min = 3, max= 25, message = "El campo debe tener entre 3 y 25 caracteres")
    @NotBlank(message = "El campo es requerido")
    private String falla;


    public CreateFallaDto(String falla, String idFalla){
        this.falla = falla;
        this.idFalla = idFalla;
    }

    public String getIdFalla() {
        return idFalla;
    }

    public void setIdFalla(String idFalla) {
        this.idFalla = idFalla;
    }

    public String getFalla() {
        return falla;
    }

    public void setFalla(String falla) {
        this.falla = falla;
    }
}
