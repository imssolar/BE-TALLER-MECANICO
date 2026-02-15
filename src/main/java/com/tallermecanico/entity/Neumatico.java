package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "neumaticos")
public class Neumatico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha_instalacion")
    private LocalDate fechaInstalacion;

    @Column
    private Integer kilometraje;

    @Column
    private Short posicion;

    @Column(precision = 8, scale = 2)
    private BigDecimal profundidad;

    @Column
    private Integer presion;

    @Column(name = "marca_fuego", length = 15)
    private String marcaFuego;

    @Column
    private Boolean activo = true;

    @Column(name = "motivo_cambio", length = 20)
    private String motivoCambio;

    @Column(name = "fecha_cambio")
    private LocalDate fechaCambio;

    @Column(name = "km_cambio", precision = 18, scale = 0)
    private BigDecimal kmCambio;

    @Column(length = 30)
    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bus", nullable = false)
    private Bus bus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", nullable = false)
    private EstadosNeumatico estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca", nullable = false)
    private MarcasNeumatico marca;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modelo", nullable = false)
    private ModelosNeumatico modeloNeumatico;

    // Constructors
    public Neumatico() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaInstalacion() {
        return fechaInstalacion;
    }

    public void setFechaInstalacion(LocalDate fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    public Integer getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Integer kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Short getPosicion() {
        return posicion;
    }

    public void setPosicion(Short posicion) {
        this.posicion = posicion;
    }

    public BigDecimal getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(BigDecimal profundidad) {
        this.profundidad = profundidad;
    }

    public Integer getPresion() {
        return presion;
    }

    public void setPresion(Integer presion) {
        this.presion = presion;
    }

    public String getMarcaFuego() {
        return marcaFuego;
    }

    public void setMarcaFuego(String marcaFuego) {
        this.marcaFuego = marcaFuego;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getMotivoCambio() {
        return motivoCambio;
    }

    public void setMotivoCambio(String motivoCambio) {
        this.motivoCambio = motivoCambio;
    }

    public LocalDate getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(LocalDate fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public BigDecimal getKmCambio() {
        return kmCambio;
    }

    public void setKmCambio(BigDecimal kmCambio) {
        this.kmCambio = kmCambio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public EstadosNeumatico getEstado() {
        return estado;
    }

    public void setEstado(EstadosNeumatico estado) {
        this.estado = estado;
    }

    public MarcasNeumatico getMarca() {
        return marca;
    }

    public void setMarca(MarcasNeumatico marca) {
        this.marca = marca;
    }

    public ModelosNeumatico getModeloNeumatico() {
        return modeloNeumatico;
    }

    public void setModeloNeumatico(ModelosNeumatico modeloNeumatico) {
        this.modeloNeumatico = modeloNeumatico;
    }
}
