package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateRegistroMensualDto {

    private Integer anio;

    @Size(max = 5, message = "El ítem no debe exceder los 5 caracteres")
    private String item;

    private Integer enero;

    private Integer febrero;

    private Integer marzo;

    private Integer abril;

    private Integer mayo;

    private Integer junio;

    private Integer julio;

    private Integer agosto;

    private Integer septiembre;

    private Integer octubre;

    private Integer noviembre;

    private Integer diciembre;

    @Size(max = 15, message = "El tipo no debe exceder los 15 caracteres")
    private String tipo;

    // Constructors
    public UpdateRegistroMensualDto() {
    }

    // Getters and Setters
    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getEnero() {
        return enero;
    }

    public void setEnero(Integer enero) {
        this.enero = enero;
    }

    public Integer getFebrero() {
        return febrero;
    }

    public void setFebrero(Integer febrero) {
        this.febrero = febrero;
    }

    public Integer getMarzo() {
        return marzo;
    }

    public void setMarzo(Integer marzo) {
        this.marzo = marzo;
    }

    public Integer getAbril() {
        return abril;
    }

    public void setAbril(Integer abril) {
        this.abril = abril;
    }

    public Integer getMayo() {
        return mayo;
    }

    public void setMayo(Integer mayo) {
        this.mayo = mayo;
    }

    public Integer getJunio() {
        return junio;
    }

    public void setJunio(Integer junio) {
        this.junio = junio;
    }

    public Integer getJulio() {
        return julio;
    }

    public void setJulio(Integer julio) {
        this.julio = julio;
    }

    public Integer getAgosto() {
        return agosto;
    }

    public void setAgosto(Integer agosto) {
        this.agosto = agosto;
    }

    public Integer getSeptiembre() {
        return septiembre;
    }

    public void setSeptiembre(Integer septiembre) {
        this.septiembre = septiembre;
    }

    public Integer getOctubre() {
        return octubre;
    }

    public void setOctubre(Integer octubre) {
        this.octubre = octubre;
    }

    public Integer getNoviembre() {
        return noviembre;
    }

    public void setNoviembre(Integer noviembre) {
        this.noviembre = noviembre;
    }

    public Integer getDiciembre() {
        return diciembre;
    }

    public void setDiciembre(Integer diciembre) {
        this.diciembre = diciembre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
