package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateItemRRHHDto {

    @NotBlank(message = "El ítem RRHH es requerido")
    @Size(max = 60, message = "El ítem RRHH no debe exceder los 60 caracteres")
    private String item;

    // Constructors
    public CreateItemRRHHDto() {
    }

    // Getters and Setters
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
