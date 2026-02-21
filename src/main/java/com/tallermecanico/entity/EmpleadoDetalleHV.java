package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "empleado_detalle_hv")
public class EmpleadoDetalleHV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rut", length = 12)
    private String rut;

    @Column(name = "observacion", length = 30)
    private String observacion;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    @Column(name = "comentario", length = 200)
    private String comentario;

    // Constructors
    public EmpleadoDetalleHV() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
