package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UpdateBateriaPasoDto {

    private Integer idBus;

    private LocalDate fechaCambio;

    private Integer idModelo;

    private Integer idMarca;

    @Size(max = 10, message = "La marca de fuego no debe exceder los 10 caracteres")
    private String marcaFuego;

    private Integer idTerminal;

    // Constructors
    public UpdateBateriaPasoDto() {
    }

    // Getters and Setters
    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    public LocalDate getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(LocalDate fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getMarcaFuego() {
        return marcaFuego;
    }

    public void setMarcaFuego(String marcaFuego) {
        this.marcaFuego = marcaFuego;
    }

    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }
}
