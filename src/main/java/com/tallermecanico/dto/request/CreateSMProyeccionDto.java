package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class CreateSMProyeccionDto {

    private LocalDate fechaActual;

    @Size(max = 50, message = "El terminal no debe exceder los 50 caracteres")
    private String terminal;

    @Size(max = 50, message = "El modelo no debe exceder los 50 caracteres")
    private String modelo;

    @Min(value = 0, message = "El km recorrido debe ser mayor o igual a 0")
    private Long kmRecorrido;

    @Size(max = 50, message = "El SM no debe exceder los 50 caracteres")
    private String sm;

    @Min(value = 0, message = "Los minutos deben ser mayor o igual a 0")
    private Long minutos;

    @Min(value = 0, message = "Las horas deben ser mayor o igual a 0")
    private Long horas;

    private LocalDate fechaInicio;

    private LocalDate fechaTermino;

    @Min(value = 0, message = "Los días deben ser mayor o igual a 0")
    private Long dias;

    @Min(value = 0, message = "Los recursos deben ser mayor o igual a 0")
    private Long recursos;

    // Constructors
    public CreateSMProyeccionDto() {
    }

    // Getters and Setters
    public LocalDate getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(LocalDate fechaActual) {
        this.fechaActual = fechaActual;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getKmRecorrido() {
        return kmRecorrido;
    }

    public void setKmRecorrido(Long kmRecorrido) {
        this.kmRecorrido = kmRecorrido;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public Long getMinutos() {
        return minutos;
    }

    public void setMinutos(Long minutos) {
        this.minutos = minutos;
    }

    public Long getHoras() {
        return horas;
    }

    public void setHoras(Long horas) {
        this.horas = horas;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(LocalDate fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public Long getDias() {
        return dias;
    }

    public void setDias(Long dias) {
        this.dias = dias;
    }

    public Long getRecursos() {
        return recursos;
    }

    public void setRecursos(Long recursos) {
        this.recursos = recursos;
    }
}
