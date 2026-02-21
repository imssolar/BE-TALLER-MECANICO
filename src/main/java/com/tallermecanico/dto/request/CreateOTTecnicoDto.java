package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class CreateOTTecnicoDto {

    private Integer idOrdenTrabajo;

    private Integer idOrdenTrabajoProg;

    @Size(max = 50, message = "El nombre no puede exceder 50 caracteres")
    private String nombre;

    @Size(max = 15, message = "El tipo no puede exceder 15 caracteres")
    private String tipo;

    @Size(max = 35, message = "El cargo no puede exceder 35 caracteres")
    private String cargo;

    private LocalDateTime horaInicio;

    private LocalDateTime horaTermino;

    // Constructors
    public CreateOTTecnicoDto() {
    }

    // Getters and Setters
    public Integer getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public Integer getIdOrdenTrabajoProg() {
        return idOrdenTrabajoProg;
    }

    public void setIdOrdenTrabajoProg(Integer idOrdenTrabajoProg) {
        this.idOrdenTrabajoProg = idOrdenTrabajoProg;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDateTime getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(LocalDateTime horaTermino) {
        this.horaTermino = horaTermino;
    }
}
