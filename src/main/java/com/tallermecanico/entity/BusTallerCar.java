package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "buses_taller_car")
public class BusTallerCar {

    @Id
    @Column(name = "id_bus")
    private Integer idBus;

    @Column(name = "patente_b", length = 7)
    private String patenteB;

    @Column(name = "marca_b", length = 50)
    private String marcaB;

    @Column(name = "motor_b", length = 50)
    private String motorB;

    @Column(name = "modelo_b", length = 15)
    private String modeloB;

    @Column(name = "anio_fab_b")
    private Integer anioFabB;

    @Column(name = "transmision_b", length = 15)
    private String transmisionB;

    @Column(name = "operativa_b")
    private Boolean operativaB;

    @Column(name = "km_b")
    private Integer kmB;

    @Column(name = "zona_b", length = 2)
    private String zonaB;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_terminal")
    private Terminal terminal;

    @Column(name = "nro_neumaticos_b")
    private Short nroNeumaticosB;

    @Column(name = "activo_b")
    private Boolean activoB;

    @Column(name = "f_emergencia_b", length = 10)
    private String fEmergenciaB;

    @Column(name = "h_emergencia_b", length = 10)
    private String hEmergenciaB;

    @Column(name = "obs_emergencia_b", length = 80)
    private String obsEmergenciaB;

    @Column(name = "abastecimiento_b")
    private Boolean abastecimientoB;

    @Column(name = "mantencion_b")
    private Boolean mantencionB;

    @Column(name = "operacion_b")
    private Boolean operacionB;

    @Column(name = "no_controlada_b")
    private Boolean noControladaB;

    @Column(name = "operativa_patio")
    private Boolean operativaPatio;

    @Column(name = "proy_rep", length = 10)
    private String proyRep;

    @Column(name = "nro_baterias")
    private Integer nroBaterias;

    // Constructors
    public BusTallerCar() {
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

    public String getModeloB() {
        return modeloB;
    }

    public void setModeloB(String modeloB) {
        this.modeloB = modeloB;
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

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
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

    public String getFEmergenciaB() {
        return fEmergenciaB;
    }

    public void setFEmergenciaB(String fEmergenciaB) {
        this.fEmergenciaB = fEmergenciaB;
    }

    public String getHEmergenciaB() {
        return hEmergenciaB;
    }

    public void setHEmergenciaB(String hEmergenciaB) {
        this.hEmergenciaB = hEmergenciaB;
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

    public Integer getNroBaterias() {
        return nroBaterias;
    }

    public void setNroBaterias(Integer nroBaterias) {
        this.nroBaterias = nroBaterias;
    }
}
