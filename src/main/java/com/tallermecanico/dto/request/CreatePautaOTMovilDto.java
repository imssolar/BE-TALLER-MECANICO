package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreatePautaOTMovilDto {

    @NotBlank(message = "La pauta OT de móvil es requerida")
    @Size(max = 50, message = "La pauta OT de móvil no debe exceder los 50 caracteres")
    private String pauta;

    @Size(max = 2, message = "El código de pauta no debe exceder los 2 caracteres")
    private String codigoPauta;

    @Size(max = 15, message = "El control no debe exceder los 15 caracteres")
    private String control;

    @Size(max = 2, message = "El formato no debe exceder los 2 caracteres")
    private String formato;

    // Constructors
    public CreatePautaOTMovilDto() {
    }

    // Getters and Setters
    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }

    public String getCodigoPauta() {
        return codigoPauta;
    }

    public void setCodigoPauta(String codigoPauta) {
        this.codigoPauta = codigoPauta;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
