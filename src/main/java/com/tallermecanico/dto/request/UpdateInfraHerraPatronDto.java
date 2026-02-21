package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class UpdateInfraHerraPatronDto {

    private Integer idTerminal;

    @Size(max = 35, message = "El modelo no debe exceder los 35 caracteres")
    private String modelo;

    @Size(max = 20, message = "La serie no debe exceder los 20 caracteres")
    private String serie;

    @Size(max = 25, message = "La marca no debe exceder los 25 caracteres")
    private String marca;

    @Size(max = 255, message = "La descripción no debe exceder los 255 caracteres")
    private String descripcion;

    private Integer anio;

    @Size(max = 50, message = "El responsable no debe exceder los 50 caracteres")
    private String responsable;

    @Size(max = 20, message = "El tipo no debe exceder los 20 caracteres")
    private String tipo;

    private LocalDate fechaCalibracion;

    private LocalDate fechaVigencia;

    @Size(max = 15, message = "El periodo no debe exceder los 15 caracteres")
    private String periodo;

    // Constructors
    public UpdateInfraHerraPatronDto() {
    }

    public UpdateInfraHerraPatronDto(Integer idTerminal, String modelo, String serie, String marca,
                                     String descripcion, Integer anio, String responsable, String tipo,
                                     LocalDate fechaCalibracion, LocalDate fechaVigencia, String periodo) {
        this.idTerminal = idTerminal;
        this.modelo = modelo;
        this.serie = serie;
        this.marca = marca;
        this.descripcion = descripcion;
        this.anio = anio;
        this.responsable = responsable;
        this.tipo = tipo;
        this.fechaCalibracion = fechaCalibracion;
        this.fechaVigencia = fechaVigencia;
        this.periodo = periodo;
    }

    // Getters and Setters
    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaCalibracion() {
        return fechaCalibracion;
    }

    public void setFechaCalibracion(LocalDate fechaCalibracion) {
        this.fechaCalibracion = fechaCalibracion;
    }

    public LocalDate getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(LocalDate fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
