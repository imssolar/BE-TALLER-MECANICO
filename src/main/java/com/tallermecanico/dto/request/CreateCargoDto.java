package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CreateCargoDto {
    @Size(max = 20, message = "El cargo no puede tener más de 20 caracteres")
    @NotBlank(message = "El campo es requerido")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El cargo solo puede contener letras y espacios")
    private String cargo;

    public CreateCargoDto(){}

    public CreateCargoDto(String cargo){
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
