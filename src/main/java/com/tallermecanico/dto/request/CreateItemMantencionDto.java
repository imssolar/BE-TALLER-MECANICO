package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateItemMantencionDto {

    @NotBlank(message = "La descripción del ítem de mantención es requerida")
    @Size(max = 65, message = "La descripción del ítem de mantención no debe exceder los 65 caracteres")
    private String descripcion;

    @Min(value = 0, message = "El orden Gantt debe ser mayor o igual a 0")
    private Integer ordenGantt;

    // Constructors
    public CreateItemMantencionDto() {
    }

    // Getters and Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getOrdenGantt() {
        return ordenGantt;
    }

    public void setOrdenGantt(Integer ordenGantt) {
        this.ordenGantt = ordenGantt;
    }
}
