package com.tallermecanico.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ot_tecnicos")
public class OTTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_trabajo")
    private OrdenTrabajo ordenTrabajo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_trabajo_prog")
    private OrdenTrabajoProg ordenTrabajoProg;

    @Column(length = 50)
    private String nombre;

    @Column(length = 15)
    private String tipo;

    @Column(length = 35)
    private String cargo;

    @Column(name = "hora_inicio")
    private LocalDateTime horaInicio;

    @Column(name = "hora_termino")
    private LocalDateTime horaTermino;

    // Constructors
    public OTTecnico() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public OrdenTrabajoProg getOrdenTrabajoProg() {
        return ordenTrabajoProg;
    }

    public void setOrdenTrabajoProg(OrdenTrabajoProg ordenTrabajoProg) {
        this.ordenTrabajoProg = ordenTrabajoProg;
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
