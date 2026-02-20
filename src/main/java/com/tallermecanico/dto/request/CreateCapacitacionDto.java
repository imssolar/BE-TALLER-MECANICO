package com.tallermecanico.dto.request;

import com.tallermecanico.enums.ActividadCapacitacion;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateCapacitacionDto {

    private LocalDate fecha;

    private ActividadCapacitacion actividad;

    @Size(max = 80, message = "El tema no debe exceder los 80 caracteres")
    private String tema;

    @Size(max = 80, message = "El objetivo no debe exceder los 80 caracteres")
    private String objetivo;

    private Integer idRelator;

    private Integer idArea;

    @DecimalMin(value = "0", message = "La duración debe ser mayor o igual a 0")
    private BigDecimal duracion;

    @Size(max = 30, message = "El lugar no debe exceder los 30 caracteres")
    private String lugar;

    @Size(max = 80, message = "El comentario no debe exceder los 80 caracteres")
    private String comentario;

    @Size(max = 80, message = "La mejora no debe exceder los 80 caracteres")
    private String mejora;

    private LocalDate fechaTermino;

    private Integer idTerminal;

    // Constructors
    public CreateCapacitacionDto() {
    }

    // Getters and Setters
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ActividadCapacitacion getActividad() {
        return actividad;
    }

    public void setActividad(ActividadCapacitacion actividad) {
        this.actividad = actividad;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Integer getIdRelator() {
        return idRelator;
    }

    public void setIdRelator(Integer idRelator) {
        this.idRelator = idRelator;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public BigDecimal getDuracion() {
        return duracion;
    }

    public void setDuracion(BigDecimal duracion) {
        this.duracion = duracion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getMejora() {
        return mejora;
    }

    public void setMejora(String mejora) {
        this.mejora = mejora;
    }

    public LocalDate getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(LocalDate fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }
}
