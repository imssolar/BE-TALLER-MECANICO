package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateBusKMMensualDto {

    @NotNull(message = "El id del bus es requerido")
    private Integer idBus;

    @NotNull(message = "El mes es requerido")
    @Min(value = 1, message = "El mes debe ser mayor o igual a 1")
    @Max(value = 12, message = "El mes debe ser menor o igual a 12")
    private Integer mes;

    @NotNull(message = "El año es requerido")
    @Min(value = 2000, message = "El año debe ser mayor o igual a 2000")
    private Integer ano;

    @Size(max = 7, message = "La patente no puede exceder 7 caracteres")
    private String patente;

    @Min(value = 0, message = "El km debe ser mayor o igual a 0")
    private Integer km;

    @Min(value = 0, message = "Los litros deben ser mayor o igual a 0")
    private Integer litros;

    // Constructors
    public CreateBusKMMensualDto() {
    }

    // Getters and Setters
    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public Integer getLitros() {
        return litros;
    }

    public void setLitros(Integer litros) {
        this.litros = litros;
    }
}
