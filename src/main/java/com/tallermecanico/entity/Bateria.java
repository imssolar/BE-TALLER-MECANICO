package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "baterias")
public class Bateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bus", nullable = false)
    private Bus bus;

    @Column(name = "fecha_instalacion")
    private LocalDate fechaInstalacion;

    @Column
    private Integer kilometraje;

    @Column
    private Short posicion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private BateriasEstado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca")
    private MarcasBateria marca;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modelo")
    private BateriaModelo modelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_terminal")
    private Terminal terminal;

    @Column(name = "cracn_king", length = 20)
    private String cracnKing;

    @Column
    private Boolean activo = true;

    @Column(name = "id_plan_rend", length = 10)
    private String idPlanRend;

    @Column(name = "marca_fuego", length = 10)
    private String marcaFuego;

    @Column(name = "fecha_cambio")
    private LocalDate fechaCambio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_motivo_cambio")
    private BateriaMotivoCambio motivoCambio;

    @Column(name = "km_cambio")
    private Integer kmCambio;

    @Column
    private Integer proyeccion;

    @Column(length = 20)
    private String visor;

    @Column(precision = 14, scale = 2)
    private BigDecimal ohms;

    @Column(name = "cca_salida")
    private Integer ccaSalida;

    @Column(name = "observaciones_baja", length = 50)
    private String observacionesBaja;

    // Constructors
    public Bateria() {
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

    public BateriasEstado getEstado() {
        return estado;
    }

    public void setEstado(BateriasEstado estado) {
        this.estado = estado;
    }

    public MarcasBateria getMarca() {
        return marca;
    }

    public void setMarca(MarcasBateria marca) {
        this.marca = marca;
    }

    public BateriaModelo getModelo() {
        return modelo;
    }

    public void setModelo(BateriaModelo modelo) {
        this.modelo = modelo;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public String getCracnKing() {
        return cracnKing;
    }

    public void setCracnKing(String cracnKing) {
        this.cracnKing = cracnKing;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getIdPlanRend() {
        return idPlanRend;
    }

    public void setIdPlanRend(String idPlanRend) {
        this.idPlanRend = idPlanRend;
    }

    public String getMarcaFuego() {
        return marcaFuego;
    }

    public void setMarcaFuego(String marcaFuego) {
        this.marcaFuego = marcaFuego;
    }

    public LocalDate getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(LocalDate fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public BateriaMotivoCambio getMotivoCambio() {
        return motivoCambio;
    }

    public void setMotivoCambio(BateriaMotivoCambio motivoCambio) {
        this.motivoCambio = motivoCambio;
    }

    public Integer getKmCambio() {
        return kmCambio;
    }

    public void setKmCambio(Integer kmCambio) {
        this.kmCambio = kmCambio;
    }

    public Integer getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(Integer proyeccion) {
        this.proyeccion = proyeccion;
    }

    public String getVisor() {
        return visor;
    }

    public void setVisor(String visor) {
        this.visor = visor;
    }

    public BigDecimal getOhms() {
        return ohms;
    }

    public void setOhms(BigDecimal ohms) {
        this.ohms = ohms;
    }

    public Integer getCcaSalida() {
        return ccaSalida;
    }

    public void setCcaSalida(Integer ccaSalida) {
        this.ccaSalida = ccaSalida;
    }

    public String getObservacionesBaja() {
        return observacionesBaja;
    }

    public void setObservacionesBaja(String observacionesBaja) {
        this.observacionesBaja = observacionesBaja;
    }
}
