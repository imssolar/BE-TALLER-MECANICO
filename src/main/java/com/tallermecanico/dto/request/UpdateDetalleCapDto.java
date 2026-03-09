package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateDetalleCapDto {

    private Integer idCapacitacion;

    @Size(max = 70, message = "El nombre no debe exceder los 70 caracteres")
    private String nombre;

    @Size(max = 12, message = "El RUN no debe exceder los 12 caracteres")
    private String run;

    private Integer nota;

    private Integer porcentajeObtenido;

    private Integer porcentajeAsistencia;

    // Constructors
    public UpdateDetalleCapDto() {
    }

    // Getters and Setters
    public Integer getIdCapacitacion() {
        return idCapacitacion;
    }

    public void setIdCapacitacion(Integer idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Integer getPorcentajeObtenido() {
        return porcentajeObtenido;
    }

    public void setPorcentajeObtenido(Integer porcentajeObtenido) {
        this.porcentajeObtenido = porcentajeObtenido;
    }

    public Integer getPorcentajeAsistencia() {
        return porcentajeAsistencia;
    }

    public void setPorcentajeAsistencia(Integer porcentajeAsistencia) {
        this.porcentajeAsistencia = porcentajeAsistencia;
    }
}
