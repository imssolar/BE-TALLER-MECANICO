package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_cap")
public class DetalleCap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_capacitacion")
    private Capacitacion capacitacion;

    @Column(name = "nombre", length = 70)
    private String nombre;

    @Column(name = "run", length = 12)
    private String run;

    @Column(name = "nota")
    private Integer nota;

    @Column(name = "porcentaje_obtenido")
    private Integer porcentajeObtenido;

    @Column(name = "porcentaje_asistencia")
    private Integer porcentajeAsistencia;

    // Constructors
    public DetalleCap() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Capacitacion getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(Capacitacion capacitacion) {
        this.capacitacion = capacitacion;
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
