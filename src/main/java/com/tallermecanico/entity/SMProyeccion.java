package com.tallermecanico.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "sm_proyeccion")
public class SMProyeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha_actual")
    private LocalDate fechaActual;

    @Column(name = "terminal", length = 50)
    private String terminal;

    @Column(name = "modelo", length = 50)
    private String modelo;

    @Column(name = "km_recorrido")
    private Long kmRecorrido;

    @Column(name = "sm", length = 50)
    private String sm;

    @Column(name = "minutos")
    private Long minutos;

    @Column(name = "horas")
    private Long horas;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_termino")
    private LocalDate fechaTermino;

    @Column(name = "dias")
    private Long dias;

    @Column(name = "recursos")
    private Long recursos;

    // Constructors
    public SMProyeccion() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
