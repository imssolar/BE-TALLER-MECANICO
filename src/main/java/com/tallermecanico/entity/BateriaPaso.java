package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "baterias_paso")
public class BateriaPaso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bus")
    private Bus bus;

    @Column(name = "fecha_cambio")
    private LocalDate fechaCambio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modelo")
    private BateriaModelo modelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca")
    private MarcasBateria marca;

    @Column(name = "marca_fuego", length = 10)
    private String marcaFuego;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_terminal")
    private Terminal terminal;

    // Constructors
    public BateriaPaso() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public LocalDate getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(LocalDate fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public BateriaModelo getModelo() {
        return modelo;
    }

    public void setModelo(BateriaModelo modelo) {
        this.modelo = modelo;
    }

    public MarcasBateria getMarca() {
        return marca;
    }

    public void setMarca(MarcasBateria marca) {
        this.marca = marca;
    }

    public String getMarcaFuego() {
        return marcaFuego;
    }

    public void setMarcaFuego(String marcaFuego) {
        this.marcaFuego = marcaFuego;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }
}
