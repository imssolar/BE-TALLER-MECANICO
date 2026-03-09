package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateRequisitoMTTDto {

    @Size(max = 70, message = "El requisito MTT no debe exceder los 70 caracteres")
    private String requisito;

    @Size(max = 1, message = "El tipo no debe exceder 1 caracter")
    private String tipo;

    @Size(max = 2, message = "El tipo de filtro no debe exceder los 2 caracteres")
    private String tipoFiltro;

    // Constructors
    public UpdateRequisitoMTTDto() {
    }

    // Getters and Setters
    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoFiltro() {
        return tipoFiltro;
    }

    public void setTipoFiltro(String tipoFiltro) {
        this.tipoFiltro = tipoFiltro;
    }
}
