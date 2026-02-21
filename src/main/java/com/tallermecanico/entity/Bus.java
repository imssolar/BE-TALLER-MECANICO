package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "buses")
public class Bus {

    @Id
    @Column(name = "id_bus")
    private Integer idBus;

    @Column(name = "patente_b", length = 8)
    private String patenteB;

    @Column(name = "marca_b", length = 50)
    private String marcaB;

    @Column(name = "motor_b", length = 50)
    private String motorB;

    @Column(name = "anio_fab_b")
    private Integer anioFabB;

    @Column(name = "transmision_b", length = 15)
    private String transmisionB;

    @Column(name = "operativa_b")
    private Boolean operativaB = false;

    @Column(name = "km_b")
    private Integer kmB;

    @Column(name = "zona_b", length = 2)
    private String zonaB;

    @Column(name = "nro_neumaticos_b")
    private Short nroNeumaticosB;

    @Column(name = "activo_b")
    private Boolean activoB = true;

    @Column(name = "nro_baterias")
    private Integer nroBaterias;

    @Column(name = "fecha_emergencia")
    private LocalDateTime fechaEmergencia;

    @Column(name = "obs_emergencia_b", length = 80)
    private String obsEmergenciaB;

    @Column(name = "abastecimiento_b")
    private Boolean abastecimientoB = false;

    @Column(name = "mantencion_b")
    private Boolean mantencionB = false;

    @Column(name = "operacion_b")
    private Boolean operacionB = false;

    @Column(name = "no_controlada_b")
    private Boolean noControladaB = false;

    @Column(name = "operativa_patio")
    private Boolean operativaPatio = false;

    @Column(name = "proy_rep", length = 10)
    private String proyRep;

    @Column(name = "fecha_revision_tecnica")
    private LocalDate fechaRevisionTecnica;

    @Column(name = "fecha_revision_gases")
    private LocalDate fechaRevisionGases;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_terminal")
    private Terminal terminal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Neumatico> neumaticos;

    // Constructors
    public Bus() {
    }

    public Bus(Integer idBus) {
        this.idBus = idBus;
    }

    // Getters and Setters
    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    public String getPatenteB() {
        return patenteB;
    }

    public void setPatenteB(String patenteB) {
        this.patenteB = patenteB;
    }

    public String getMarcaB() {
        return marcaB;
    }

    public void setMarcaB(String marcaB) {
        this.marcaB = marcaB;
    }

    public String getMotorB() {
        return motorB;
    }

    public void setMotorB(String motorB) {
        this.motorB = motorB;
    }

    public Integer getAnioFabB() {
        return anioFabB;
    }

    public void setAnioFabB(Integer anioFabB) {
        this.anioFabB = anioFabB;
    }

    public String getTransmisionB() {
        return transmisionB;
    }

    public void setTransmisionB(String transmisionB) {
        this.transmisionB = transmisionB;
    }

    public Boolean getOperativaB() {
        return operativaB;
    }

    public void setOperativaB(Boolean operativaB) {
        this.operativaB = operativaB;
    }

    public Integer getKmB() {
        return kmB;
    }

    public void setKmB(Integer kmB) {
        this.kmB = kmB;
    }

    public String getZonaB() {
        return zonaB;
    }

    public void setZonaB(String zonaB) {
        this.zonaB = zonaB;
    }

    public Short getNroNeumaticosB() {
        return nroNeumaticosB;
    }

    public void setNroNeumaticosB(Short nroNeumaticosB) {
        this.nroNeumaticosB = nroNeumaticosB;
    }

    public Boolean getActivoB() {
        return activoB;
    }

    public void setActivoB(Boolean activoB) {
        this.activoB = activoB;
    }

    public Integer getNroBaterias() {
        return nroBaterias;
    }

    public void setNroBaterias(Integer nroBaterias) {
        this.nroBaterias = nroBaterias;
    }

    public LocalDateTime getFechaEmergencia() {
        return fechaEmergencia;
    }

    public void setFechaEmergencia(LocalDateTime fechaEmergencia) {
        this.fechaEmergencia = fechaEmergencia;
    }

    public String getObsEmergenciaB() {
        return obsEmergenciaB;
    }

    public void setObsEmergenciaB(String obsEmergenciaB) {
        this.obsEmergenciaB = obsEmergenciaB;
    }

    public Boolean getAbastecimientoB() {
        return abastecimientoB;
    }

    public void setAbastecimientoB(Boolean abastecimientoB) {
        this.abastecimientoB = abastecimientoB;
    }

    public Boolean getMantencionB() {
        return mantencionB;
    }

    public void setMantencionB(Boolean mantencionB) {
        this.mantencionB = mantencionB;
    }

    public Boolean getOperacionB() {
        return operacionB;
    }

    public void setOperacionB(Boolean operacionB) {
        this.operacionB = operacionB;
    }

    public Boolean getNoControladaB() {
        return noControladaB;
    }

    public void setNoControladaB(Boolean noControladaB) {
        this.noControladaB = noControladaB;
    }

    public Boolean getOperativaPatio() {
        return operativaPatio;
    }

    public void setOperativaPatio(Boolean operativaPatio) {
        this.operativaPatio = operativaPatio;
    }

    public String getProyRep() {
        return proyRep;
    }

    public void setProyRep(String proyRep) {
        this.proyRep = proyRep;
    }

    public LocalDate getFechaRevisionTecnica() {
        return fechaRevisionTecnica;
    }

    public void setFechaRevisionTecnica(LocalDate fechaRevisionTecnica) {
        this.fechaRevisionTecnica = fechaRevisionTecnica;
    }

    public LocalDate getFechaRevisionGases() {
        return fechaRevisionGases;
    }

    public void setFechaRevisionGases(LocalDate fechaRevisionGases) {
        this.fechaRevisionGases = fechaRevisionGases;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public List<Neumatico> getNeumaticos() {
        return neumaticos;
    }

    public void setNeumaticos(List<Neumatico> neumaticos) {
        this.neumaticos = neumaticos;
    }
}
