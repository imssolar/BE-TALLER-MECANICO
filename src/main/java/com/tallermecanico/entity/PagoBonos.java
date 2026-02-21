package com.tallermecanico.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pago_bonos")
public class PagoBonos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha", unique = true, nullable = false)
    private LocalDate fecha;

    public PagoBonos() {
    }

    public PagoBonos(Integer id, LocalDate fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
