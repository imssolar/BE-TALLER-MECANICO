package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "infra_herra_patron")
public class InfraHerraPatron {

    @Id
    @Column(name = "id_infra", length = 25)
    private String idInfra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_terminal")
    private Terminal terminal;

    @Column(name = "modelo", length = 35)
    private String modelo;

    @Column(name = "serie", length = 20)
    private String serie;

    @Column(name = "marca", length = 25)
    private String marca;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "responsable", length = 50)
    private String responsable;

    @Column(name = "tipo", length = 20)
    private String tipo;

    @Column(name = "fecha_calibracion")
    private LocalDate fechaCalibracion;

    @Column(name = "fecha_vigencia")
    private LocalDate fechaVigencia;

    @Column(name = "periodo", length = 15)
    private String periodo;

    // Constructors
    public InfraHerraPatron() {
    }

    public InfraHerraPatron(String idInfra, Terminal terminal, String modelo, String serie, String marca,
                            String descripcion, Integer anio, String responsable, String tipo,
                            LocalDate fechaCalibracion, LocalDate fechaVigencia, String periodo) {
        this.idInfra = idInfra;
        this.terminal = terminal;
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
    public String getIdInfra() {
        return idInfra;
    }

    public void setIdInfra(String idInfra) {
        this.idInfra = idInfra;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
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
