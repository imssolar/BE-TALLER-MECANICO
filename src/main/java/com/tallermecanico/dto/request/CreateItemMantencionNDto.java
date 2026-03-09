package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateItemMantencionNDto {

    @NotBlank(message = "La descripción es requerida")
    @Size(max = 65, message = "La descripción no puede exceder 65 caracteres")
    private String descripcion;

    private Integer idModelo;

    @Min(value = 0, message = "El periodo no puede ser negativo")
    private Integer periodo;

    // Constructors
    public CreateItemMantencionNDto() {
    }

    // Getters and Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }
}
