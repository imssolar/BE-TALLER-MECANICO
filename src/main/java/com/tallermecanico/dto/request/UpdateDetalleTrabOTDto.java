package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateDetalleTrabOTDto {

    private Integer idOrdenTrabajo;

    @Size(max = 60, message = "El trabajo no puede exceder 60 caracteres")
    private String trabajo;

    private Short tipo;

    // Constructors
    public UpdateDetalleTrabOTDto() {
    }

    // Getters and Setters
    public Integer getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public Short getTipo() {
        return tipo;
    }

    public void setTipo(Short tipo) {
        this.tipo = tipo;
    }
}
