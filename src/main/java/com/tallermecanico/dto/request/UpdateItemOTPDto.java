package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateItemOTPDto {

    @Size(max = 50, message = "El ítem OTP no debe exceder los 50 caracteres")
    private String item;

    @Size(max = 3, message = "La pauta no debe exceder los 3 caracteres")
    private String pauta;

    @Size(max = 2, message = "El tipo no debe exceder los 2 caracteres")
    private String tipo;

    @Size(max = 15, message = "El control no debe exceder los 15 caracteres")
    private String control;

    @Size(max = 2, message = "El formato no debe exceder los 2 caracteres")
    private String formato;

    // Constructors
    public UpdateItemOTPDto() {
    }

    // Getters and Setters
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
